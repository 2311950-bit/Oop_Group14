package com.example.oop_group14.shopowner;

import com.example.oop_group14.shopowner.Modelclass.Register;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class RegisterShopInformationController
{
    @FXML
    private ComboBox<String> areaCB;

    @FXML
    private TableColumn<Register, String> areacoulmn;

    @FXML
    private TextField namefield;

    @FXML
    private TextField search;

    @FXML
    private TableColumn<Register, String> ownercoulmn;

    @FXML
    private TableColumn<Register, String> shopcoulmn;

    @FXML
    private TextField shopnamefield;

    @FXML
    private TableView<Register> tableinfo;

    @FXML
    private ComboBox<String> typeCB;

    @FXML
    private TableColumn<Register, String> wastecoulmn;

    private Register register;
    private ArrayList<Register> array = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        typeCB.getItems().addAll("Plastic", "Glass", "Metal", "Paper", "Organic");
        areaCB.getItems().addAll("Dhanmondi", "Mirpur", "Gulshan", "Uttara", "Mohammadpur");
        areacoulmn.setCellValueFactory(new PropertyValueFactory<>("area"));
        shopcoulmn.setCellValueFactory(new PropertyValueFactory<>("shopName"));
        ownercoulmn.setCellValueFactory(new PropertyValueFactory<>("name"));
        wastecoulmn.setCellValueFactory(new PropertyValueFactory<>("wasteType"));


    }

    @javafx.fxml.FXML
    public void searchbutton(ActionEvent actionEvent) {
        if (search.getText().isEmpty()) {
            tableinfo.getItems().clear();
            tableinfo.getItems().addAll(array);
        } else {
            tableinfo.getItems().clear();
            for (Register r : array) {
                if (r.getShopName().equalsIgnoreCase(search.getText()) || r.getName().equalsIgnoreCase(search.getText()) || r.getArea().equalsIgnoreCase(search.getText()) || r.getWasteType().equalsIgnoreCase(search.getText())){
                    tableinfo.getItems().add(r);
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void registerbutton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (namefield.getText().isEmpty() || shopnamefield.getText().isEmpty() || areaCB.getValue() == null || typeCB.getValue() == null) {
            alert.setContentText("Please fill up all the information");
            alert.showAndWait();
            return;
        }

        register = new Register(namefield.getText(), shopnamefield.getText(), areaCB.getValue(), typeCB.getValue());
        tableinfo.getItems().add(register);
        array.add(register);

        namefield.clear();
        shopnamefield.clear();
        areaCB.setValue(null);
        typeCB.setValue(null);
    }

    @FXML
    public void resetbutton(ActionEvent actionEvent) {
        tableinfo.getItems().clear();
        tableinfo.getItems().addAll(array);
    }
}