package com.example.oop_group14.shopowner;

import com.example.oop_group14.shopowner.Modelclass.Submit;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class ViewGarbageTruckScheduleController
{
    @javafx.fxml.FXML
    private ComboBox<String> optionCB;
    @javafx.fxml.FXML
    private TableView<Submit> tableinfo;
    @javafx.fxml.FXML
    private TableColumn<Submit, String> areaColumn;
    @javafx.fxml.FXML
    private TableColumn<Submit, String> commentColumn;
    @javafx.fxml.FXML
    private TableColumn<Submit, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<Submit, String> shopNameColumn;

    @javafx.fxml.FXML
    public void initialize() {
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        shopNameColumn.setCellValueFactory(new PropertyValueFactory<>("shopName"));
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));


    }

    @javafx.fxml.FXML
    public void loadbutton(ActionEvent actionEvent) {
        try (ObjectInputStream input = new ObjectInputStream( new FileInputStream("submit.bin"))) {
            tableinfo.getItems().clear();
            int size = input.read();
            for (int i = 0; i < size; i++) {
                Submit submit = (Submit) input.readObject();
                optionCB.getItems().add(submit.getArea());
                tableinfo.getItems().add(submit);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void filterButton(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        String selectedArea = optionCB.getSelectionModel().getSelectedItem();
        if (selectedArea == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Filtered Data");
            alert.setHeaderText(null);
            alert.setContentText("To Filter Data Select an Area");
            alert.showAndWait();
        } else {
            tableinfo.getItems().clear();
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("submit.bin"))) {
                int size = input.read();
                for (int i = 0; i < size; i++) {
                    Submit submit = (Submit) input.readObject();
                    if (submit.getArea().equals(selectedArea)) {
                        tableinfo.getItems().add(submit);
                    }
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}