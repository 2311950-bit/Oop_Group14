package com.example.oop_group14.Mila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CitizenController {

    private final WasteManagementService service = WasteManagementService.getInstance();
    private int loggedInUserId = -1;

    public void setUserId(int userId) {
        this.loggedInUserId = userId;
    }

    private void switchScene(ActionEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Navigation Error", "Could not load the requested page: " + fxmlPath);
        }
    }

    private void showAlert(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


    @FXML public void garbagePickupOA(ActionEvent actionEvent) {
        String billInfo = String.format("Billing Information (User ID: %d)\n\nPrevious Balance: $15.00\nCurrent Charges: $10.00 (Standard monthly fee)\nDue Date: 2026-01-01\n\nStatus: Pending", loggedInUserId);
        showAlert(AlertType.INFORMATION, "View Bill", "Garbage Collection Bill", billInfo);
    }

    @FXML public void TruckTrackingOA(ActionEvent actionEvent) {
        List<String> tracking = service.getTruckTrackingInfo();
        String info = String.join("\n", tracking);
        showAlert(AlertType.INFORMATION, "Truck Tracking", "Estimated Arrival Times", info);
    }

    @FXML public void UncollectedGarbageOA(ActionEvent actionEvent) {
        Complaint newComplaint = service.submitNewComplaint(
                loggedInUserId,
                "Uncollected Garbage",
                "My recycling bin was missed today.",
                "Road 10, House 5"
        );
        showAlert(AlertType.INFORMATION, "Complaint Submitted", "Report Successful",
                "Your report of uncollected garbage has been submitted.\nComplaint ID: " + newComplaint.getComplaintId() + "\nStatus: " + newComplaint.getStatus());
    }

    @FXML public void recyclingGuidelinesOA(ActionEvent actionEvent) {
        String guidelines = service.getRecyclingGuidelines();
        showAlert(AlertType.INFORMATION, "Recycling Centers & Guidelines", "Information", guidelines);
    }

    @FXML public void OnlinePaymentOA(ActionEvent actionEvent) {
        String payment = "Payment of $10.00 was successful.\nTransaction ID: 789456.\nThank you for your payment.";
        showAlert(AlertType.CONFIRMATION, "Make Payment", "Online Payment", payment);
    }

    @FXML public void cleanlinessFeedbackOA(ActionEvent actionEvent) {
        String sampleFeedback = "The waste collection service has been very punctual this month.";
        service.submitFeedback(sampleFeedback);
        showAlert(AlertType.INFORMATION, "Feedback Submitted", "Thank You",
                "Your feedback ('" + sampleFeedback + "') has been recorded!");
    }

    @FXML public void ComplaintSOA(ActionEvent actionEvent) {
        List<Complaint> myComplaints = service.getCitizenComplaints(loggedInUserId);
        StringBuilder sb = new StringBuilder("--- Your Complaint History ---\n");
        if (myComplaints.isEmpty()) {
            sb.append("No complaints found.");
        } else {
            myComplaints.forEach(c ->
                    sb.append(String.format("ID: %d | Category: %s | Status: %s\n", c.getComplaintId(), c.getCategory(), c.getStatus()))
            );
        }
        showAlert(AlertType.INFORMATION, "Complaint Status", "Viewing Your Submissions", sb.toString());
    }

    @FXML public void logoutOA(ActionEvent actionEvent) {
        switchScene(actionEvent, "login.fxml", "Login Page");
    }
}