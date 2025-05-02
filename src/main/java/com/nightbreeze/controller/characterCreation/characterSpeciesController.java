package com.nightbreeze.controller.characterCreation;

import com.nightbreeze.util.CharacterData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static com.nightbreeze.controller.characterCreation.characterNameController.character;

import java.net.URL;
import java.util.ResourceBundle;

// -----------------
// 8 races : Dragonborn; Dwarf; Elf; Gnome; Halfling; Half-Elf; Human; Tiefling

public class characterSpeciesController implements Initializable {

    @FXML private Button dragonbornButton;
    @FXML private Button dwarfButton;
    @FXML private Button elfButton;
    @FXML private Button gnomeButton;
    @FXML private Button halflingButton;
    @FXML private Button halfElfButton;
    @FXML private Button humanButton;
    @FXML private Button tieflingButton;

    CharacterData characterData = new CharacterData();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void dragonbornButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("Dragonborn");
        characterData.saveCharacterData(character);
    }

    public void dwarfButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("Dwarf");
        characterData.saveCharacterData(character);
    }

    public void elfButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("Elf");
        characterData.saveCharacterData(character);
    }

    public void gnomeButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("Gnome");
        characterData.saveCharacterData(character);
    }

    public void halflingButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("Halfling");
        characterData.saveCharacterData(character);
    }

    public void halfElfButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("HalfElf");
        characterData.saveCharacterData(character);
    }

    public void humanButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("Human");
        characterData.saveCharacterData(character);
    }

    public void tieflingButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("Tiefling");
        characterData.saveCharacterData(character);
    }


}

