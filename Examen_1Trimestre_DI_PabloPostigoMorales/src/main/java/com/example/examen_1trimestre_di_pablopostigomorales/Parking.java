package com.example.examen_1trimestre_di_pablopostigomorales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Parking extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Parking.class.getResource("parking-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 975);
        stage.setTitle("Ejercicio de examen");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}