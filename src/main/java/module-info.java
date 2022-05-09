module com.example.advancedproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.advancedproject to javafx.fxml;
    exports com.example.advancedproject;
}