package com.example.oop_group14.shopowner;

import com.example.oop_group14.shopowner.Modelclass.Register;
import com.example.oop_group14.shopowner.Modelclass.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class TrackDailyWestOutputController {

    @FXML
    private TextField amountfield;

    @FXML
    private TableColumn<Track, String> datecoulmn;

    @FXML
    private TableColumn<Track, String> namecoulmn;

    @FXML
    private TextField namefield;

    @FXML
    private TextField search;

    @FXML
    private TableView<Track> tableinfo;

    @FXML
    private TableColumn<Track, String> typecoulmn;

    @FXML
    private ComboBox<String> westCB;

    @FXML
    private TableColumn<Track, String> westcoulmn;

    Track track;
    ArrayList<Track> tracklist = new ArrayList<>();


    @FXML
    public void initialize(){
        westCB.getItems().addAll("plastic","paper","glass","organic");
        datecoulmn.setCellValueFactory(new PropertyValueFactory<>("date"));
        namecoulmn.setCellValueFactory(new PropertyValueFactory<>("shopName"));
        typecoulmn.setCellValueFactory(new PropertyValueFactory<>("type"));
        westcoulmn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    @FXML
    void resetbutton(ActionEvent event) {
        tableinfo.getItems().clear();
        tableinfo.getItems().addAll(tracklist);


    }

    @FXML
    void savebutton(ActionEvent event) {
        track=new Track(namefield.getText(),westCB.getValue(),Integer.parseInt(amountfield.getText()));
        tableinfo.getItems().add(track);
        tracklist.add(track);

    }

    @FXML
    void searchbutton(ActionEvent event) {
        if (search.getText().isEmpty()) {
            tableinfo.getItems().clear();
            tableinfo.getItems().addAll(tracklist);
        } else {
            tableinfo.getItems().clear();
            for (Track r : tracklist) {
                if (r.getShopName().equalsIgnoreCase(search.getText()) || r.getShopName().equalsIgnoreCase(search.getText()) || r.getAmount() == Integer.parseInt(search.getText()) || r.getType().equalsIgnoreCase(search.getText())) {
                    tableinfo.getItems().add(r);
                }
            }


        }

    }
    }
