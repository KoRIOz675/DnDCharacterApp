package com.nightbreeze;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

import com.nightbreeze.util.GUIManager;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        GUIManager.loadStage("home-page");
    }

    public static void main(String[] args) {
        launch();
    }
}
