package com.example.oop_group14.Mila;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ViewComplaintStatusController
{
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextField complaintIDTF;
    @javafx.fxml.FXML
    private TableColumn<Complaint,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<Complaint, Integer> complaintIDTC;
    @javafx.fxml.FXML
    private TableColumn<Complaint,LocalDate> dateTC;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TextArea complaintsTA;

    @javafx.fxml.FXML
    public void initialize() {

        complaintIDTC.setCellValueFactory(new PropertyValueFactory<>("complaint"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

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
    public void complaintOnAction(ActionEvent actionEvent) {

        Integer complaintID = Integer.parseInt(complaintIDTF.getText());
        LocalDate date = dateDatePicker.getValue();
    }

    @javafx.fxml.FXML
    public void backtoOA(ActionEvent actionEvent) {

        switchScene(actionEvent, "ViewComplaintStatus.fxml", "Complaint Status");
    }
}