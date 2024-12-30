module com.example.compoundinterestapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.compoundinterestapp to javafx.fxml;
    exports com.example.compoundinterestapp;
}