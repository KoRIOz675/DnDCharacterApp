package com.nightbreeze.controller.characterCreation;

import static com.nightbreeze.controller.characterCreation.characterNameController.character;

import com.nightbreeze.util.CharacterData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class characterClassController implements Initializable {

    @FXML
    private Button barbarianButton;

    @FXML
    private Button bardButton;

    @FXML
    private Button clericButton;

    @FXML
    private Button druidButton;

    @FXML
    private Button fighterButton;

    @FXML
    private Button monkButton;

    @FXML
    private Button paladinButton;

    @FXML
    private Button rangerButton;

    @FXML
    private Button rogueButton;

    @FXML
    private Button sorcererButton;

    @FXML
    private Button warlockButton;

    @FXML
    private Button wizardButton;

    CharacterData characterData = new CharacterData();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void barbarianButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("barbarian");
        characterData.saveCharacterData(character);
    }

    public void bardButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("bard");
        characterData.saveCharacterData(character);
    }

    public void clericButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("cleric");
        characterData.saveCharacterData(character);
    }

    public void druidButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("druid");
        characterData.saveCharacterData(character);
    }

    public void fighterButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("fighter");
        characterData.saveCharacterData(character);
    }

    public void monkButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("monk");
        characterData.saveCharacterData(character);
    }

    public void paladinButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("paladin");
        characterData.saveCharacterData(character);
    }

    public void rangerButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("ranger");
        characterData.saveCharacterData(character);
    }

    public void rogueButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("rogue");
        characterData.saveCharacterData(character);
    }

    public void sorcererButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("sorcerer");
        characterData.saveCharacterData(character);
    }

    public void warlockButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("warlock");
        characterData.saveCharacterData(character);
    }

    public void wizardButtonOnAction(ActionEvent actionEvent) {
        character.setClassName("wizard");
        characterData.saveCharacterData(character);
    }
}
