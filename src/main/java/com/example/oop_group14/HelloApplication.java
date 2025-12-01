package com.example.oop_group14;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {                                 // "/com/example/oop_group14/comunityleaderfdsdfdxml shopownerfxml/add_and_View.fxml"
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/oop_group14/shopownerfxml/Submit_Waste_Pickup_Request.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
