package com.example.oop_group14.Mila;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class GiveCleanlinessFeedbackController
{
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> serviceCB;
    @javafx.fxml.FXML
    private TextArea feedbackTA;
    @javafx.fxml.FXML
    private TextField authorNameTF;

    @javafx.fxml.FXML
    public void initialize() {

        serviceCB.getItems().addAll("Garbage Not Collected","Bad Smell in the Area","Unclean","Public Dustbin Broken");
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
            showAlert(Alert.AlertType.ERROR, "Error", "Navigation Error", "Could not load the requested page: " + fxmlPath);
        }
    }

    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backtoOA(ActionEvent actionEvent) {

        switchScene(actionEvent, "CitizenDashboard.fxml", "CitizenDashboard");
    }

    @javafx.fxml.FXML
    public void feedbackOA(ActionEvent actionEvent) {

        String feedback = feedbackTA.getText();
        String authorName = authorNameTF.getText();
        String service = serviceCB.getValue();
        LocalDate date = dateDatePicker.getValue();



    }
}