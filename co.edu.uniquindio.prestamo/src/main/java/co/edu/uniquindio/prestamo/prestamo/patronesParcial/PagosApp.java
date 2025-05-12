package co.edu.uniquindio.prestamo.prestamo.patronesParcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PagosApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(co.edu.uniquindio.prestamo.prestamo.patronesParcial.PagosApp.class.getResource("PatronFacadeParcial.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Prestamo!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}