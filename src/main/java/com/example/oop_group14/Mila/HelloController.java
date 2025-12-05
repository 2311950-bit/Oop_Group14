package com.example.oop_group14.Mila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private final WasteManagementService service = WasteManagementService.getInstance();

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label loginMessageLabel;

    @FXML
    protected void loginBtnOnAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            loginMessageLabel.setText("Please enter username and password.");
            return;
        }

        String role = service.authenticate(username, password);

        if (role.equals("Citizen")) {
            int citizenId = service.getCitizenId(username);
            loadCitizenDashboard(event, citizenId);

        } else if (role.equals("WMO")) {
            loadWMODashboard(event);

        } else {
            loginMessageLabel.setText("Invalid credentials (Use: wmo/pass or registered citizen account)");
        }
    }

    @FXML
    protected void goToSignUp(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignUp.fxml"));
            Parent root = fxmlLoader.load(); // Corrected typo: fxmlLoader

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Citizen Registration");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            loginMessageLabel.setText("Error loading Sign Up page.");
        }
    }

    private void loadCitizenDashboard(ActionEvent event, int userId) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CitizenDashboard.fxml"));
            Parent root = fxmlLoader.load();

            CitizenController controller = fxmlLoader.getController();
            controller.setUserId(userId);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Citizen Dashboard (ID: " + userId + ")");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            loginMessageLabel.setText("Error loading Citizen dashboard.");
        }
    }

    private void loadWMODashboard(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WasteManagementOfficerDashboard.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("WMO Dashboard");
            stage.setScene(new Scene(root, 950, 750));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            loginMessageLabel.setText("Error loading WMO dashboard.");
        }
    }
}