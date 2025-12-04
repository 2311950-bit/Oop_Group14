module com.example.oop_group {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop_group14.comunityleader to javafx.fxml;
    opens com.example.oop_group14.comunityleader.Modelclass to javafx.base;
    opens com.example.oop_group14.shopowner to javafx.fxml;
    opens com.example.oop_group14.shopowner.Modelclass to javafx.base;
    opens com.example.oop_group14 to javafx.fxml;
    exports com.example.oop_group14;
}