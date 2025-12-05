package com.example.oop_group14.comunityleader;

import com.example.oop_group14.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class ComunityleaderDashBoardController
{
    @javafx.fxml.FXML
    private BorderPane borderPane;
    @javafx.fxml.FXML
    private BarChart barchart;
    @javafx.fxml.FXML
    private AnchorPane centeralPane;
    @javafx.fxml.FXML
    private NumberAxis yAxis;
    @javafx.fxml.FXML
    private CategoryAxis xAxis;
    @javafx.fxml.FXML
    private TableColumn remarksColumn;
    @javafx.fxml.FXML
    private TableColumn collectedWasteColumn;
    @javafx.fxml.FXML
    private TableColumn areaNameColumn;
    @javafx.fxml.FXML
    private TableView tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void manageComunityButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/comunityleaderfxml/manage_Community_Composting_Participation_List.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void addAndViewButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/comunityleaderfxml/add_and_View.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void dashboardButton(ActionEvent actionEvent) {
        borderPane.setCenter(centeralPane);
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void announcementButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/comunityleaderfxml/send_Announcements.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void weeklySummaryButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/comunityleaderfxml/generate_Weekly_Summary.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void viewComplainsButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/comunityleaderfxml/view_Complaints.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void assignCleaningButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/comunityleaderfxml/assign_Cleaning.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void rateSenitationButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/comunityleaderfxml/rate_Sanitation.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void requestExtraButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/com/example/oop_group14/comunityleaderfxml/request_Extra.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }
}