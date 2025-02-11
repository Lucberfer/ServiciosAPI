package org.example.demoserviciosapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        try {
            VBox root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/demoserviciosapi/views/HttpController.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Gmail Sender App");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
