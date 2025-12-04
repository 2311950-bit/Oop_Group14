package com.example.oop_group14.comunityleader;

import com.example.oop_group14.comunityleader.Modelclass.Manage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class manageCommunityCompostingControllerController {

    @FXML
    private TableColumn<Manage, String> areaCoulmn;

    @FXML
    private TextField areaField;

    @FXML
    private TableColumn<Manage, String> binCoulmn;

    @FXML
    private ToggleGroup compositbin;

    @FXML
    private TableColumn<Manage, String> dateCoulmn;

    @FXML
    private RadioButton doesRB;

    @FXML
    private RadioButton doesntRB;

    @FXML
    private TableColumn<Manage, String> nameCoulmn;

    @FXML
    private TextField nameField;

    @FXML
    private TableView<Manage> tableinfo;

    Manage manage ;
    ArrayList <Manage> managelist = new ArrayList<>();

    @FXML
    public void initialize(){
        nameCoulmn.setCellValueFactory(new PropertyValueFactory<>("name"));
        areaCoulmn.setCellValueFactory(new PropertyValueFactory<>("area"));
        binCoulmn.setCellValueFactory(new PropertyValueFactory<>("bin"));
        dateCoulmn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    void saveButton(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.WARNING);
        if(nameField.getText().isEmpty() || areaField.getText().isEmpty()|| compositbin.getSelectedToggle()==null){
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        String compostbin = ((RadioButton) this.compositbin.getSelectedToggle()).getText();

        LocalDate date = LocalDate.now();
        manage =new Manage(nameField.getText(),areaField.getText(),binCoulmn.getText(),date.toString());
        tableinfo.getItems().add(manage);
        managelist.add(manage);

        nameField.clear();
        areaField.clear();
        compositbin.getSelectedToggle().setSelected(false);

    }

}
