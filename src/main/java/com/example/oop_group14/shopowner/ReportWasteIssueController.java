package com.example.oop_group14.shopowner;

import com.example.oop_group14.shopowner.Modelclass.Report;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReportWasteIssueController
{
    @javafx.fxml.FXML
    private TableColumn<Report, String> issuecoulmn;
    @javafx.fxml.FXML
    private TextArea issuetextarea;
    @javafx.fxml.FXML
    private TableColumn<Report, String> datecoulmn;
    @javafx.fxml.FXML
    private TableView<Report> tableinfo;


    private Report report;
    private ArrayList<Report> reportlist = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
       issuecoulmn.setCellValueFactory(new PropertyValueFactory<>("issueDetails"));
       datecoulmn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void submitbutton(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (issuetextarea.getText().isEmpty()) {
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the issue");
            alert.showAndWait();
            return;
        }

        LocalDate date = LocalDate.now();
        report = new Report(issuetextarea.getText(), date.toString());
        reportlist.add(report);
        tableinfo.getItems().add(report);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("report.bin"))) {
            output.write(reportlist.size());
            for (Report r : reportlist) {
                output.writeObject(r);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}