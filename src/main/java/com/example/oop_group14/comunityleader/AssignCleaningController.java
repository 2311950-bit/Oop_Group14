package com.example.oop_group14.comunityleader;

import com.example.oop_group14.comunityleader.Modelclass.Assign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class AssignCleaningController {

    @FXML
    private TableColumn<Assign,String> areacoulmn;

    @FXML
    private TextField areafield;

    @FXML
    private TextField areafield1;

    @FXML
    private DatePicker dateDP;

    @FXML
    private TableColumn<Assign,String> datecoulmn;

    @FXML
    private TableColumn<Assign,String> namecoulmn;

    @FXML
    private TextField namefield;

    @FXML
    private TableView<Assign> tableinfo;

    @FXML
    private TableColumn<Assign,String> taskcoulmn;

    Assign assign;
    ArrayList <Assign> assignlist = new ArrayList<>();

    @FXML
    public void initialize(){
        areacoulmn.setCellValueFactory(new PropertyValueFactory<>("area"));
        datecoulmn.setCellValueFactory(new PropertyValueFactory<>("date"));
        namecoulmn.setCellValueFactory(new PropertyValueFactory<>("name"));
        taskcoulmn.setCellValueFactory(new PropertyValueFactory<>("task"));

    }

    @FXML
    void assignbutton(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        if(areafield.getText().isEmpty()||areafield1.getText().isEmpty()||namefield.getText().isEmpty()||dateDP.getValue()==null) {
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }


            assign = new Assign(namefield.getText(), areafield.getText(), areafield1.getText(), dateDP.getValue());
            tableinfo.getItems().add(assign);
            assignlist.add(assign);

            areafield.clear();
            areafield1.clear();
            namefield.clear();
            dateDP.setValue(null);

        }
}
