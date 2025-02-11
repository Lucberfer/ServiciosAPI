module org.example.demoserviciosapi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.demoserviciosapi to javafx.fxml;
    exports org.example.demoserviciosapi;
}