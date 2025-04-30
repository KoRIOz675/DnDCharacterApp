package com.nightbreeze;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        Scene scene = new Scene(loadFXML("home-page")); // Set initial size
        stage.setTitle("DnD Character Manager"); // Set window title
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        URL fxmlUrl = App.class.getResource(fxml + ".fxml");
        if (fxmlUrl == null) {
            throw new IOException("Cannot load FXML file: " + fxml + ".fxml");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}