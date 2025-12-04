module org.example.mila {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mila to javafx.fxml;
    exports org.example.mila;
}