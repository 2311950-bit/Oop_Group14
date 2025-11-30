package com.example.oop_group14.comunityleader;

import com.example.oop_group14.comunityleader.Modelclass.AddandView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class AddAndViewController {

    @FXML
    private TextField areafield;

    @FXML
    private TableColumn<AddandView, String> namecoulmn;

    @FXML
    private TableColumn<AddandView, String> remarkscoulmn;

    @FXML
    private TextField remarksfield;

    @FXML
    private TableView<AddandView> tableinfo;

    @FXML
    private TableColumn<AddandView, String> wastekgcoulmn;

    @FXML
    private TextField westkgfield;

    AddandView addandview ;
    ArrayList <AddandView> addandViewlist = new ArrayList<>();

    @FXML
    public void initialize(){
        namecoulmn.setCellValueFactory(new PropertyValueFactory<>("areaName"));
        wastekgcoulmn.setCellValueFactory(new PropertyValueFactory<>("wasteKG"));
        remarkscoulmn.setCellValueFactory(new PropertyValueFactory<>("remarks"));

    }

    @FXML
    void savebutton(ActionEvent event) {

        Alert aleart = new Alert(Alert.AlertType.WARNING);
        if(areafield.getText().isEmpty() || remarksfield.getText().isEmpty() || westkgfield.getText().isEmpty()){
            aleart.setContentText("Please fill all the fields");
            aleart.showAndWait();
            return;
        }
        addandview = new AddandView(areafield.getText(),remarksfield.getText(),Integer.parseInt(westkgfield.getText()));
        tableinfo.getItems().add(addandview);
        addandViewlist.add(addandview);

        areafield.clear();
        remarksfield.clear();
        westkgfield.clear();

    }

}
