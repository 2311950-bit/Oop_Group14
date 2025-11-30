package com.example.oop_group14.shopowner;


import com.example.oop_group14.shopowner.Modelclass.Provide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;

public class ProvideServiceFeedbackController {

    @FXML
    private TextField areafield;

    @FXML
    private TextArea commenttextarea;

    @FXML
    private TextField namefield;
    @FXML
    private RadioButton radiobutton5;
    @FXML
    private ToggleGroup radiobutton;
    @FXML
    private RadioButton radiobutton3;
    @FXML
    private RadioButton radiobutton4;
    @FXML
    private RadioButton radiobutton1;
    @FXML
    private RadioButton radiobutton2;

    Provide provide;
    ArrayList<Provide> provideList = new ArrayList<>();

    @FXML
    void submitbutton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (namefield.getText().isEmpty() || areafield.getText().isEmpty() || commenttextarea.getText().isEmpty() || radiobutton.getSelectedToggle() == null) {
            alert.setTitle("Warning");
            alert.setHeaderText("Please fill up all the fields");
            alert.showAndWait();
            return;
        }

        String rating = ((RadioButton) radiobutton.getSelectedToggle()).getText();

        provide = new Provide(namefield.getText(), areafield.getText(), Integer.parseInt(rating), commenttextarea.getText());
        provideList.add(provide);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("provide.bin",true))) {
            output.write(provideList.size());
            for (Provide p : provideList) {
                output.writeObject(p);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

}
