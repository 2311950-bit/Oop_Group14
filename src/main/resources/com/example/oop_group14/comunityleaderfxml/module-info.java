module cse213.oopproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens cse213.oopproject.shopowener to javafx.fxml;
    opens cse213.oopproject.shopowener.ModelClass to javafx.base;
    opens cse213.oopproject.comunityleader to javafx.fxml;
    opens cse213.oopproject.comunityleader.modelclass to javafx.base;
    opens cse213.oopproject to javafx.fxml;
    exports cse213.oopproject;
}