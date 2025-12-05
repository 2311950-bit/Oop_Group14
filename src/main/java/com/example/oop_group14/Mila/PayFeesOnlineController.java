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
import java.util.ArrayList;


public class PayFeesOnlineController
{
    @javafx.fxml.FXML
    private TableColumn<payOnline,Integer> amountTC;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextField mobilenoTF;
    @javafx.fxml.FXML
    private TableColumn<payOnline,String> methodTC;
    @javafx.fxml.FXML
    private ComboBox<String> methodCB;
    @javafx.fxml.FXML
    private TextField transactionIDTF;
    @javafx.fxml.FXML
    private Label outputL;
    @javafx.fxml.FXML
    private TableColumn<payOnline,Integer> idTC;
    @javafx.fxml.FXML
    private TableColumn<payOnline,LocalDate> dateTC;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableView<payOnline> dataTV;


    ArrayList<payOnline>payOnlineArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        methodCB.getItems().addAll("Visa", "MasterCard", "DebitCard", "CreditCard");

        idTC.setCellValueFactory(new PropertyValueFactory<>("transactionID"));
        methodTC.setCellValueFactory(new PropertyValueFactory<>("method"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
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
    public void payOnAction(ActionEvent actionEvent) {

        String method = methodCB.getItems().toString();
        String mobileno = mobilenoTF.getText();
        Integer transactionID = Integer.parseInt(transactionIDTF.getText());
        Integer amount = Integer.parseInt(amountTF.getText());
        LocalDate date = dateDatePicker.getValue();

        payOnline payOnline = new payOnline(method,transactionID,mobileno,amount,date);
        payOnlineArrayList.add(payOnline);
        dataTV.getItems().add(payOnline);

    }

    @javafx.fxml.FXML
    public void backtoOA(ActionEvent actionEvent) {

        switchScene(actionEvent, "CitizenDashboard.fxml", "CitizenDashboard");
    }
}