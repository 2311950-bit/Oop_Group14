package com.example.oop_group14.shopowner;

import com.example.oop_group14.shopowner.Modelclass.Schedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduleShopCleaningStaffController {

    @FXML
    private DatePicker dateDP;

    @FXML
    private TableColumn<Schedule,String> datecoulmn;

    @FXML
    private TableColumn<Schedule,String> satffcoulmn;

    @FXML
    private TableColumn<Schedule,String> shopcoulmn;

    @FXML
    private TextField shopnamefield;

    @FXML
    private TextField staffnamefield;

    @FXML
    private TableView<Schedule> tableinfo;

    @FXML
    private ComboBox<String> taskCB;

    @FXML
    private TableColumn<Schedule,String> taskcoulmn;

    private Schedule schedule;
    private ArrayList<Schedule> array = new ArrayList<>();

    @FXML
    public void initialize() {

        taskCB.getItems().addAll("Cleaning", "Security", "Maintenance", "Other");
        datecoulmn.setCellValueFactory(new PropertyValueFactory<>("date"));
        satffcoulmn.setCellValueFactory(new PropertyValueFactory<>("name"));
        shopcoulmn.setCellValueFactory(new PropertyValueFactory<>("shopName"));
        taskcoulmn.setCellValueFactory(new PropertyValueFactory<>("task"));

    }



    @FXML
    public void savebutton(ActionEvent actionevent) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (staffnamefield.getText().isEmpty() || shopnamefield.getText().isEmpty() || taskCB.getValue() == null || dateDP.getValue() == null) {
            alert.setTitle("WARNING");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        LocalDate date = dateDP.getValue();
        if (date.isBefore(LocalDate.now())) {
            alert.setTitle("WARNING");
            alert.setContentText("Please select a valid date");
            alert.showAndWait();
            return;
        }

        schedule = new Schedule(staffnamefield.getText() , shopnamefield.getText(), taskCB.getValue(), dateDP.getValue());
        array.add(schedule);
        tableinfo.getItems().addAll(schedule);

        staffnamefield.clear();
        shopnamefield.clear();
        taskCB.getSelectionModel().clearSelection();
        dateDP.getEditor().clear();


    }

}
