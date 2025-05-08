package com.nightbreeze.controller.characterCreation;

import static com.nightbreeze.controller.characterCreation.characterNameController.character;

import com.nightbreeze.util.CharacterData;
import com.nightbreeze.util.Dice;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CharacterStatsController implements Initializable {

    @FXML
    private TextField strengthTextField;

    @FXML
    private TextField dexterityTextField;

    @FXML
    private TextField constitutionTextField;

    @FXML
    private TextField inteligenceTextField;

    @FXML
    private TextField wisdomTextField;

    @FXML
    private TextField charismaTextField;

    @FXML
    private Button strengthRandomButton;

    @FXML
    private Button dexterityRandomButton;

    @FXML
    private Button constitutionRandomButton;

    @FXML
    private Button inteligenceRandomButton;

    @FXML
    private Button wisdomRandomButton;

    @FXML
    private Button charismaRandomButton;

    @FXML
    private Button okButton;

    @FXML
    private Label strengthBonusLabel;

    @FXML
    private Label dexterityBonusLabel;

    @FXML
    private Label constitutionBonusLabel;

    @FXML
    private Label inteligenceBonusLabel;

    @FXML
    private Label wisdomBonusLabel;

    @FXML
    private Label charismaBonusLabel;

    CharacterData characterData = new CharacterData();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        disableAllBonusLabel(true);
        if (character.getStrength() != 0) {
            int tempStrength = character.getStrength();
            strengthBonusLabel.setText("Current Bonus: +" + tempStrength);
        }
        if (character.getDexterity() != 0) {
            int tempDexterity = character.getDexterity();
            dexterityBonusLabel.setText("Current Bonus: +" + tempDexterity);
        }
        if (character.getConstitution() != 0) {
            int tempConstitution = character.getConstitution();
            constitutionBonusLabel.setText("Current Bonus: +" + tempConstitution);
        }
        if (character.getIntelligence() != 0) {
            int tempIntelligence = character.getIntelligence();
            inteligenceBonusLabel.setText("Current Bonus: +" + tempIntelligence);
        }
        if (character.getWisdom() != 0) {
            int tempWisdom = character.getWisdom();
            wisdomBonusLabel.setText("Current Bonus: +" + tempWisdom);
        }
        if (character.getCharisma() != 0) {
            int tempCharisma = character.getCharisma();
            charismaBonusLabel.setText("Current Bonus: +" + tempCharisma);
        }
    }

    public void strengthRandomButtonAction(ActionEvent event) {}

    public void randomStatistic(String stat) {
        int statistic = Dice.roll(20);

        if (character.getStrength() != 0) {
            int tempStrength = character.getStrength();
        } else if (character.getDexterity() != 0) {
            int tempDexterity = character.getDexterity();
        } else if (character.getConstitution() != 0) {
            int tempConstitution = character.getConstitution();
        } else if (character.getIntelligence() != 0) {
            int tempIntelligence = character.getIntelligence();
        } else if (character.getWisdom() != 0) {
            int tempWisdom = character.getWisdom();
        } else if (character.getCharisma() != 0) {
            int tempCharisma = character.getCharisma();
        }
    }

    public void disableAllBonusLabel(Boolean disable) {
        strengthBonusLabel.setDisable(disable);
        dexterityBonusLabel.setDisable(disable);
        constitutionBonusLabel.setDisable(disable);
        inteligenceBonusLabel.setDisable(disable);
        wisdomBonusLabel.setDisable(disable);
        charismaBonusLabel.setDisable(disable);
    }
}
