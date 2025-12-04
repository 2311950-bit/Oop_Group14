package com.example.oop_group14.Mila;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class WasteManagementOfficerController {

    private final WasteManagementService service = WasteManagementService.getInstance();
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    @FXML private TextArea truckStatusArea;
    @FXML private ComboBox<String> truckIdCombo;
    @FXML private TextField routeNameField;
    @FXML private TextField startLocField;
    @FXML private TextField endLocField;
    @FXML private Label routeMessageLabel;

    @FXML private TextField workerIdField;
    @FXML private TextField shiftNameField;
    @FXML private DatePicker shiftDatePicker;
    @FXML private TextField startTimeField;
    @FXML private TextField endTimeField;
    @FXML private Label shiftMessageLabel;
    @FXML private TextArea scheduleArea;

    @FXML private ComboBox<String> complaintIdCombo;
    @FXML private ComboBox<String> statusCombo;
    @FXML private TextField resolutionField;
    @FXML private Label complaintMessageLabel;
    @FXML private TextArea complaintDetailsArea;


    @FXML
    public void initialize() {
        if (truckIdCombo != null) {
            truckIdCombo.setItems(FXCollections.observableArrayList(
                    service.getAllTrucks().stream().map(GarbageTruck::getTruckId).toList()
            ));
        }

        if (statusCombo != null) {
            statusCombo.setItems(FXCollections.observableArrayList("Pending", "In Progress", "Resolved", "Closed"));
        }

        if (complaintIdCombo != null) {
            complaintIdCombo.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal != null) {
                    displayComplaintDetails(Integer.parseInt(newVal));
                }
            });
        }

        Platform.runLater(() -> {
            if (truckStatusArea != null) handleTrackTrucks(null);
            if (scheduleArea != null) updateScheduleArea();
        });
    }


    @FXML
    public void handleTrackTrucks(ActionEvent event) {
        List<GarbageTruck> trucks = service.getAllTrucks();
        StringBuilder sb = new StringBuilder("--- Current Fleet Status ---\n");
        for (GarbageTruck truck : trucks) {
            sb.append(String.format("ID: %s | Status: %s | Location: %s | Route: %s\n",
                    truck.getTruckId(), truck.getStatus(), truck.getCurrentLocation(),
                    (truck.getCurrentRouteId() == null ? "None" : truck.getCurrentRouteId())));
        }
        truckStatusArea.setText(sb.toString());
    }


    @FXML
    public void handleAssignRoute(ActionEvent event) {
        String truckId = truckIdCombo.getValue();
        String routeName = routeNameField.getText();
        String startLoc = startLocField.getText();
        String endLoc = endLocField.getText();

        if (truckId == null || routeName.isEmpty() || startLoc.isEmpty() || endLoc.isEmpty()) {
            routeMessageLabel.setText("Please select a Truck ID and fill all route details.");
            return;
        }

        if (service.assignRouteToTruck(truckId, routeName, startLoc, endLoc)) {
            routeMessageLabel.setText("✅ Route assigned successfully to Truck " + truckId + ".");
            handleTrackTrucks(null);
        } else {
            routeMessageLabel.setText("❌ Assignment failed. Truck may be in Maintenance or ID invalid.");
        }
    }


    @FXML
    public void handleScheduleShift(ActionEvent event) {
        String workerId = workerIdField.getText();
        String shiftName = shiftNameField.getText();
        LocalDate date = shiftDatePicker.getValue();
        String startTimeStr = startTimeField.getText();
        String endTimeStr = endTimeField.getText();

        if (workerId.isEmpty() || shiftName.isEmpty() || date == null || startTimeStr.isEmpty() || endTimeStr.isEmpty()) {
            shiftMessageLabel.setText("Please fill all worker and shift details.");
            return;
        }

        try {
            LocalTime startTime = LocalTime.parse(startTimeStr, timeFormatter);
            LocalTime endTime = LocalTime.parse(endTimeStr, timeFormatter);
            LocalDateTime start = LocalDateTime.of(date, startTime);
            LocalDateTime end = LocalDateTime.of(date, endTime);

            if (end.isBefore(start) || end.isEqual(start)) {
                shiftMessageLabel.setText("End time must be after start time.");
                return;
            }

            String result = service.scheduleWorkerShift(workerId, shiftName, start, end);

            if (result.startsWith("Overlap Error")) {
                shiftMessageLabel.setText("❌ " + result);
            } else {
                shiftMessageLabel.setText("✅ " + result);
                updateScheduleArea();
            }

        } catch (DateTimeParseException e) {
            shiftMessageLabel.setText("❌ Invalid time format. Please use HH:MM (e.g., 07:30).");
        }
    }

    private void updateScheduleArea() {
        StringBuilder sb = new StringBuilder("--- Current Worker Schedule ---\n");
        service.getWorkerSchedule().forEach(shift -> sb.append(shift.toString()).append("\n"));
        scheduleArea.setText(sb.toString());
    }


    @FXML
    public void handleLoadComplaints(ActionEvent event) {
        List<Complaint> pendingComplaints = service.getPendingComplaints();
        complaintIdCombo.setItems(FXCollections.observableArrayList(
                pendingComplaints.stream().map(c -> String.valueOf(c.getComplaintId())).toList()
        ));
        complaintDetailsArea.setText("Loaded " + pendingComplaints.size() + " pending complaints.");
        complaintMessageLabel.setText("");
    }

    private void displayComplaintDetails(int complaintId) {
        Complaint c = service.getAllComplaints().stream()
                .filter(complaint -> complaint.getComplaintId() == complaintId)
                .findFirst().orElse(null);

        if (c != null) {
            complaintDetailsArea.setText(String.format(
                    "ID: %d\nCategory: %s\nAddress: %s\nDescription: %s\nStatus: %s",
                    c.getComplaintId(), c.getCategory(), c.getAddress(), c.getDescription(), c.getStatus()
            ));
        } else {
            complaintDetailsArea.setText("Complaint details not found.");
        }
    }


    @FXML
    public void handleUpdateComplaintStatus(ActionEvent event) {
        String complaintIdStr = complaintIdCombo.getValue();
        String newStatus = statusCombo.getValue();
        String resolutionSummary = resolutionField.getText();

        if (complaintIdStr == null || newStatus == null || resolutionSummary.isEmpty()) {
            complaintMessageLabel.setText("Please select a complaint, set a status, and provide a resolution.");
            return;
        }

        int complaintId = Integer.parseInt(complaintIdStr);

        String result = service.updateComplaintStatus(complaintId, newStatus, resolutionSummary);

        if (result.startsWith("Error")) {
            complaintMessageLabel.setText("❌ " + result);
        } else {
            complaintMessageLabel.setText("✅ " + result + ". Summary: " + resolutionSummary);
            handleLoadComplaints(null);
            complaintDetailsArea.clear();
        }
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }
}