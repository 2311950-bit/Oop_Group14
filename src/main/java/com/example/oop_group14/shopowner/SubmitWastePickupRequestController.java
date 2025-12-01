package com.example.oop_group14.shopowner;

import com.example.oop_group14.shopowner.Modelclass.Shop;
import com.example.oop_group14.shopowner.Modelclass.Submit;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SubmitWastePickupRequestController
{
    @javafx.fxml.FXML
    private TextField commentfield;
    @javafx.fxml.FXML
    private TextField shopnamefield;
    @javafx.fxml.FXML
    private TextField areafield;
    @javafx.fxml.FXML
    private DatePicker dateandtimeDP;

    Submit submit;
    ArrayList<Submit> submitlist = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitbutton(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        if(shopnamefield.getText().isEmpty() || areafield.getText().isEmpty() || dateandtimeDP.getValue() == null){
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }


        submit = new Submit(commentfield.toString(), shopnamefield.toString(), areafield.toString(), dateandtimeDP.getValue());
        submitlist.add(submit);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("submit.txt", true))) {
            for (Submit submit : submitlist) {
                writer.write( commentfield.toString() + "," + shopnamefield.toString() + "," + areafield.toString() + "," + dateandtimeDP.getValue());
                writer.newLine();

                Alert success = new Alert(Alert.AlertType.INFORMATION);
                success.setTitle("Success");
                success.setHeaderText("Request Submitted Successfully!");
                success.setContentText("Your waste pickup request has been saved properly.");
                success.showAndWait();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }

    }




    }
