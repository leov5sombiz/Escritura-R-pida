module com.example.estruturarapida {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires jdk.jfr;


    opens com.example.estruturarapida to javafx.fxml;
    exports com.example.estruturarapida;
    exports com.example.estruturarapida.controllers;
    opens com.example.estruturarapida.controllers to javafx.fxml;
}