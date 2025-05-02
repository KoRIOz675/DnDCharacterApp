package com.nightbreeze;

import java.io.IOException;
import java.util.List;

import com.nightbreeze.model.Species;
import com.nightbreeze.util.CharacterData;
import com.nightbreeze.util.JsonFileReader;

import javafx.application.Application;
import javafx.stage.Stage;

import com.nightbreeze.util.GUIManager;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        CharacterData.createDataFolder();
        GUIManager.loadStage("home-page");
        List<Species> allSpecies = JsonFileReader.readJsonDataFile("species");
        for (Species s : allSpecies) {
            System.out.println("Found species: " + s.getName());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
