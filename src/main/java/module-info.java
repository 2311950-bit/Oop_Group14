module com.example.oop_group {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop_group14 to javafx.fxml;
    exports com.example.oop_group14;
}