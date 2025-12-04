package org.example.mila;

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

public class SignUpController {

    private final WasteManagementService service = WasteManagementService.getInstance();

    @FXML private TextField regUsernameField;
    @FXML private PasswordField regPasswordField;
    @FXML private PasswordField regConfirmField;
    @FXML private Label regMessageLabel;

    @FXML
    protected void registerBtnOnAction(ActionEvent event) {
        String username = regUsernameField.getText();
        String password = regPasswordField.getText();
        String confirmPassword = regConfirmField.getText();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            regMessageLabel.setText("Please fill in all fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            regMessageLabel.setText("Passwords do not match.");
            return;
        }

        if (password.length() < 5) {
            regMessageLabel.setText("Password must be at least 5 characters.");
            return;
        }

        int newId = service.registerNewCitizen(username, password);

        if (newId != -1) {
            regMessageLabel.setText("✅ Registration successful! ID: " + newId);
            regMessageLabel.setStyle("-fx-text-fill: green;");

            backToLogin(event);
        } else {
            regMessageLabel.setText("❌ Registration failed. Username already taken or reserved.");
        }
    }

    @FXML
    protected void backToLogin(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Waste Management System Login");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}