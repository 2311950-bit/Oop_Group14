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
        switchScene(actionEvent, "ViewMYBill.fxml", "My Bill");
    }

    @FXML public void TruckTrackingOA(ActionEvent actionEvent) {
        List<String> tracking = service.getTruckTrackingInfo();
        String info = String.join("\n", tracking);
        showAlert(AlertType.INFORMATION, "Truck Tracking", "Estimated Arrival Times", info);
    }

    @FXML public void UncollectedGarbageOA(ActionEvent actionEvent) {
        switchScene(actionEvent, "reportUncollectedGarbage.fxml", "Report Uncollected Garbage");
    }

    @FXML public void recyclingGuidelinesOA(ActionEvent actionEvent) {
        String guidelines = service.getRecyclingGuidelines();
        showAlert(AlertType.INFORMATION, "Recycling Centers & Guidelines", "Information", guidelines);
    }

    @FXML public void OnlinePaymentOA(ActionEvent actionEvent) {
        switchScene(actionEvent, "PayFeesOnline.fxml", "View Payment");

    }

    @FXML public void cleanlinessFeedbackOA(ActionEvent actionEvent) {
        switchScene(actionEvent, "GiveCleanlinessFeedback.fxml", "CleanlinessFeedback");
    }

    @FXML public void ComplaintSOA(ActionEvent actionEvent) {
        switchScene(actionEvent, "ViewComplaintStatus.fxml", "Complaint Status");
    }

    @FXML public void logoutOA(ActionEvent actionEvent) {
        switchScene(actionEvent, "login.fxml", "Login Page");
    }
}