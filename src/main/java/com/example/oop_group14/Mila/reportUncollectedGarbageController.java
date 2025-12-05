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
import java.util.ArrayList;

public class reportUncollectedGarbageController
{
    @javafx.fxml.FXML
    private TextField locationTF;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextArea commentsTA;
    @javafx.fxml.FXML
    private ComboBox<String> timeCB;

    ArrayList<uncollectedgarbagereport>uncollectedgarbagereportArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

     timeCB.getItems().addAll("Morning","Evening","Night");


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
    public void reportOnAction(ActionEvent actionEvent) {
        String time = timeCB.getValue().toString();
        String location  = locationTF.getText();
        LocalDate date = dateDatePicker.getValue();
        String comments = commentsTA.getText();



    }

    @javafx.fxml.FXML
    public void backtoOA(ActionEvent actionEvent) {

        switchScene(actionEvent, "CitizenDashboard.fxml", "Citizen Dashboard");

    }
}