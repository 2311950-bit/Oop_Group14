package com.example.oop_group14.comunityleader;

import com.example.oop_group14.comunityleader.Modelclass.Rate;
import com.example.oop_group14.shopowner.Modelclass.Shop;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RateSanitationController
{
    @javafx.fxml.FXML
    private TextArea commentTextarea;
    @javafx.fxml.FXML
    private RadioButton rating1;
    @javafx.fxml.FXML
    private RadioButton rating2;
    @javafx.fxml.FXML
    private ComboBox<String> workerCB;
    @javafx.fxml.FXML
    private RadioButton rating3;
    @javafx.fxml.FXML
    private RadioButton rating4;
    @javafx.fxml.FXML
    private ToggleGroup rating;
    @javafx.fxml.FXML
    private RadioButton rating5;

    Rate rate;
    ArrayList <Rate> ratelist = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        workerCB.getItems().addAll("Worker 1", "Worker 2", "Worker 3");

    }

    @javafx.fxml.FXML
    public void submitbutton(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        if(rating.getSelectedToggle()==null||workerCB.getValue()==null||commentTextarea.getText().isEmpty()){
            alert.setContentText("Please fill in all fields");
            alert.showAndWait();
            return;
        }

        rate = new Rate( commentTextarea.getText(), rating.getSelectedToggle().toString(),workerCB.getValue());
        ratelist.add(rate);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rate.txt", true))) {
            for (Rate rate : ratelist) {
                writer.write(rate.getComment()+","+rate.getRate()+","+rate.getWorkerCB());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }

    }



}
