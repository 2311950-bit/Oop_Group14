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


public class ViewMyBillController
{
    @javafx.fxml.FXML
    private TableColumn<MyBill,Integer> amountTC;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField monthTF;
    @javafx.fxml.FXML
    private TableColumn<MyBill,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<MyBill,String> monthTC;
    @javafx.fxml.FXML
    private TableColumn<MyBill,LocalDate> dateTC;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableView<MyBill> dataTV;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;

    ArrayList<MyBill> MyBilArrayList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        statusCB.getItems().addAll("Paid", "Unpaid");

        monthTC.setCellValueFactory(new PropertyValueFactory<>("month"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
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
    public void viewbillOnAction(ActionEvent actionEvent) {

        String month = monthTF.getText();
        int amount = Integer.parseInt(amountTF.getText());
        String status = statusCB.getValue();
        LocalDate date = dateDatePicker.getValue();

        MyBill myBill = new MyBill(month,amount,date,status);
        MyBilArrayList.add(myBill);

        dataTV.getItems().add(myBill);


    }

    @javafx.fxml.FXML
    public void backtoOA(ActionEvent actionEvent) {

        switchScene(actionEvent, "CitizenDashboard.fxml", "CitizenDashboard");
    }
}