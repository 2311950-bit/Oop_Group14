package com.example.oop_group14.shopowner;

import com.example.oop_group14.shopowner.Modelclass.Shop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;

public class ShopWasteStorageSpaceController {

    @FXML
    private TextArea commentTextarea;

    @FXML
    private ComboBox<String> containerCB;

    @FXML
    private RadioButton radiobuttonEmpty;

    @FXML
    private RadioButton radiobuttonFull;

    @FXML
    private RadioButton radiobuttonHalf_Full;

    @FXML
    private TextField shopnamefield;

    @FXML
    private ToggleGroup status;

    @FXML
    private TextField westfield;

    Shop shop;
    ArrayList<Shop> shoplist = new ArrayList<>();

    @FXML
    public void initialize() {
        containerCB.getItems().addAll("Blue durm", "Metal durm", "plastic durm", "Other");

    }

    @FXML
    public void savebutton(ActionEvent event) {

        String status = ((RadioButton) this.status.getSelectedToggle()).getText();

        shop = new Shop(shopnamefield.getText(), westfield.getText(), containerCB.getValue(), status, commentTextarea.getText());
        shoplist.add(shop);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("shop.txt", true))) {
            for (Shop shop : shoplist) {
                writer.write(shop.getShopName() + "," + shop.getWasteStroge() + "," + shop.getContainer() + "," + shop.getStatus() + "," + shop.getComment());
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














