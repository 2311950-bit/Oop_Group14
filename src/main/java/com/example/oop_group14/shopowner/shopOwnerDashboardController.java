package com.example.oop_group14.shopowner;

import com.example.oop_group14.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class shopOwnerDashboardController
{
    @javafx.fxml.FXML
    private BarChart barchart;
    @javafx.fxml.FXML
    private NumberAxis yAxis;
    @javafx.fxml.FXML
    private CategoryAxis xAxis;
    @javafx.fxml.FXML
    private TableColumn shopColumn;
    @javafx.fxml.FXML
    private TableColumn areaColumn;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn ownerColumn;
    @javafx.fxml.FXML
    private TableColumn typeColumn;
    @javafx.fxml.FXML
    private BorderPane borderPane;
    @javafx.fxml.FXML
    private AnchorPane centeralPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void wastePickupButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/Submit_Waste_Pickup_Request.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void dashboardButton(ActionEvent actionEvent) {
        borderPane.setCenter(centeralPane);
    }

    @javafx.fxml.FXML
    public void shopRegisterButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/Register_Shop_Information.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void serviceFeedBackButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/provide_Service_Feedback.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void cleaningSchedualButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/Schedule_Shop_Cleaning_Staff.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void wasteReportButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/report_Waste_Issue.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void truckSchedualButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/view_Garbage_Truck_Schedule.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void trackDailyButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/Track_Daily_West_Output.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void wasteStorageButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/Shop_Waste_Storage_Space.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }
}