package com.nightbreeze.controller;

import com.nightbreeze.model.Character;
import com.nightbreeze.util.CharacterData;
import com.nightbreeze.util.GUIManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HomePageController implements Initializable {

    @FXML
    private Button characterButton;

    Character currentCharacter;

    @FXML
    public void characterButtonAction(ActionEvent event) throws IOException {
        if (currentCharacter == null) {
            GUIManager.loadStage("character-name");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentCharacter = CharacterData.loadCharacterData();

        if (currentCharacter == null) {
            characterButton.setText("Create a new Character");
            System.out.println("Characters' file empty.");
        } else {
            characterButton.setText("Load Character: " + currentCharacter.getName());
            System.out.println("Loaded character: " + currentCharacter.getName());
        }
    }
}
