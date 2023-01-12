module com.example.myloginjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.myloginjfx to javafx.fxml;
    exports com.example.myloginjfx;
}