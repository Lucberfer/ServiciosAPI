module org.example.demoserviciosapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires jakarta.mail;

    opens org.example.demoserviciosapi to javafx.fxml;
    opens org.example.demoserviciosapi.controller to javafx.fxml;

    exports org.example.demoserviciosapi;
    exports org.example.demoserviciosapi.controller;
}
