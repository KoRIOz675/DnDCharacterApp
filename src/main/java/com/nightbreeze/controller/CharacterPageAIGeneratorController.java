/*
 * --------------------------------
 *
 * This Controller and View as been Generated with Gemini as a base.
 * The purpose of this was to see how the project could be made.
 *
 * --------------------------------
 */

package com.nightbreeze.controller;

import com.nightbreeze.model.Character;
import com.nightbreeze.util.CharacterData;
import com.nightbreeze.util.Dice;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.IntConsumer;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;

public class CharacterPageAIGeneratorController implements Initializable {

    // FXML Injection -- Main Tab
    @FXML
    private TextField characterNameField;

    @FXML
    private Label classLevelField;

    @FXML
    private TextField raceField;

    @FXML
    private TextField alignmentField;

    @FXML
    private TextField backgroundField;

    @FXML
    private Label currentHpLabel;

    @FXML
    private Label maxHpLabel;

    @FXML
    private Label tempHpLabel;

    @FXML
    private Button damageButton;

    @FXML
    private Button healButton;

    @FXML
    private Button addTempHpButton;

    @FXML
    private CheckBox deathSaveSuccess1;

    @FXML
    private CheckBox deathSaveSuccess2;

    @FXML
    private CheckBox deathSaveSuccess3;

    @FXML
    private CheckBox deathSaveFail1;

    @FXML
    private CheckBox deathSaveFail2;

    @FXML
    private CheckBox deathSaveFail3;

    @FXML
    private Button rollDeathSaveButton;

    // FXML Injection -- Ability Tab
    @FXML
    private TextField strScoreField;

    @FXML
    private Label strModLabel;

    @FXML
    private Button rollStrCheckButton;

    @FXML
    private Button rollStrSaveButton;

    @FXML
    private TextField dexScoreField;

    @FXML
    private Label dexModLabel;

    @FXML
    private Button rollDexCheckButton;

    @FXML
    private Button rollDexSaveButton;

    @FXML
    private TextField conScoreField;

    @FXML
    private Label conModLabel;

    @FXML
    private Button rollConCheckButton;

    @FXML
    private Button rollConSaveButton;

    @FXML
    private TextField intScoreField;

    @FXML
    private Label intModLabel;

    @FXML
    private Button rollIntCheckButton;

    @FXML
    private Button rollIntSaveButton;

    @FXML
    private TextField wisScoreField;

    @FXML
    private Label wisModLabel;

    @FXML
    private Button rollWisCheckButton;

    @FXML
    private Button rollWisSaveButton;

    @FXML
    private TextField chaScoreField;

    @FXML
    private Label chaModLabel;

    @FXML
    private Button rollChaCheckButton;

    @FXML
    private Button rollChaSaveButton;

    // FXML Injection -- Notes Tab
    @FXML
    private TextArea personalityTraitsArea;

    @FXML
    private TextArea idealsArea;

    @FXML
    private TextArea bondsArea;

    @FXML
    private TextArea flawsArea;

    @FXML
    private TextArea backstoryArea;

    // FXML Injection -- TabPane
    @FXML
    private TabPane tabPane;

    // Character Data Model
    private Character currentCharacter;

    // Init
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.currentCharacter = CharacterData.loadCharacterData();

        if (this.currentCharacter == null) {
            this.currentCharacter = new Character(); // Create a fresh character
            System.out.println("Created a new default character.");
        } else {
            System.out.println("Loaded character: " + this.currentCharacter.getName());
        }

        bindCharacterData();

        addAbilityScoreListener();

        updateAbilityModifiers();
    }

    public void bindCharacterData() {
        NumberStringConverter converter = new NumberStringConverter();

        // Basic Info Binding
        characterNameField.textProperty().bindBidirectional(currentCharacter.CharacterNameProperty());
        classLevelField.textProperty().bind(currentCharacter.classLevelProperty().asString());
        raceField.textProperty().bindBidirectional(currentCharacter.raceProperty());
        alignmentField.textProperty().bindBidirectional(currentCharacter.alignmentProperty());
        backgroundField.textProperty().bindBidirectional(currentCharacter.backgroundProperty());

        // HP Binding
        currentHpLabel.textProperty().bind(currentCharacter.currentHPProperty().asString());
        maxHpLabel.textProperty().bind(currentCharacter.maxHPProperty().asString());
        tempHpLabel.textProperty().bind(currentCharacter.temporaryHPProperty().asString());

        // Ability Binding
        Bindings.bindBidirectional(strScoreField.textProperty(), currentCharacter.strengthProperty(), converter);
        Bindings.bindBidirectional(dexScoreField.textProperty(), currentCharacter.dexterityProperty(), converter);
        Bindings.bindBidirectional(conScoreField.textProperty(), currentCharacter.constitutionProperty(), converter);
        Bindings.bindBidirectional(intScoreField.textProperty(), currentCharacter.intelligenceProperty(), converter);
        Bindings.bindBidirectional(wisScoreField.textProperty(), currentCharacter.wisdomProperty(), converter);
        Bindings.bindBidirectional(chaScoreField.textProperty(), currentCharacter.charismaProperty(), converter);
    }

    public void addAbilityScoreListener() {
        currentCharacter.strengthProperty().addListener((obs, oldValue, newValue) -> updateAbilityModifiers());
        currentCharacter.dexterityProperty().addListener((obs, oldValue, newValue) -> updateAbilityModifiers());
        currentCharacter.constitutionProperty().addListener((obs, oldValue, newValue) -> updateAbilityModifiers());
        currentCharacter.intelligenceProperty().addListener((obs, oldValue, newValue) -> updateAbilityModifiers());
        currentCharacter.wisdomProperty().addListener((obs, oldValue, newValue) -> updateAbilityModifiers());
        currentCharacter.charismaProperty().addListener((obs, oldValue, newValue) -> updateAbilityModifiers());

        // Initial Update
        updateAbilityModifiers();
    }

    public void updateAbilityModifiers() {
        strModLabel.setText(formatModifier(currentCharacter.getStrengthModifier()));
        dexModLabel.setText(formatModifier(currentCharacter.getDexterityModifier()));
        conModLabel.setText(formatModifier(currentCharacter.getConstitutionModifier()));
        intModLabel.setText(formatModifier(currentCharacter.getIntelligenceModifier()));
        wisModLabel.setText(formatModifier(currentCharacter.getWisdomModifier()));
        chaModLabel.setText(formatModifier(currentCharacter.getCharismaModifier()));
    }

    public String formatModifier(int modifier) {
        return (modifier >= 0) ? "+" + modifier : String.valueOf(modifier);
    }

    // Event Handlers
    // Main Tab Handlers
    @FXML
    private void damageButtonAction() {
        showNumberInputDialog("Take Damage", "Enter amount of damage:", currentCharacter::damage);
    }

    @FXML
    private void healButtonAction() {
        showNumberInputDialog("Receive Healing", "Enter amount healed:", currentCharacter::heal);
    }

    @FXML
    private void tempHpButtonAction() {
        showNumberInputDialog("Add Temporary HP", "Enter amount of temporary HP:", currentCharacter::temporaryHP);
    }

    @FXML
    private void rollDeathSaveButtonAction() {
        int roll = Dice.roll(20);
        String resultText;
        if (roll == 1) {
            resultText = "Critical Failure (2 Failures)";
            // Logic to mark 2 failures (e.g., find first two unchecked fail boxes)
        } else if (roll < 10) {
            resultText = "Failure (1 Failure)";
            // Logic to mark 1 failure
        } else if (roll == 20) {
            resultText = "Critical Success (2 Successes)";
        } else { // 10-19
            resultText = "Success (1 Success)";
            // Logic to mark 1 success
        }
        Dice.showRollResult("Death Saving Throw", roll, resultText);
        // Add logic here to actually check the boxes based on the result
    }

    // Ability Handlers
    @FXML
    private void rollStrCheckButtonAction() {
        int modifier = currentCharacter.getStrengthModifier();
        int roll = Dice.rollD20(modifier);
        Dice.showRollResult("Strength Check", roll, "Roll (1d20" + formatModifier(modifier) + ")");
    }

    @FXML
    private void rollStrSaveButtonAction() {
        boolean isProficient = false; // Placeholder
        int proficientBonus = 2; // Placeholder
        int modifier = currentCharacter.getStrengthModifier();
        int saveBonus = modifier + (isProficient ? proficientBonus : 0);
        int roll = Dice.rollD20(saveBonus);
        Dice.showRollResult("Strength Saving Throw", roll, "Roll (1d20" + formatModifier(saveBonus) + ")");
    }

    @FXML
    private void rollDexCheckButtonAction() {
        int modifier = currentCharacter.getDexterityModifier();
        int roll = Dice.rollD20(modifier);
        Dice.showRollResult("Dexterity Check", roll, "Roll (1d20" + formatModifier(modifier) + ")");
    }

    @FXML
    private void rollDexSaveButtonAction() {
        boolean isProficient = false; // Placeholder
        int proficientBonus = 2; // Placeholder
        int modifier = currentCharacter.getDexterityModifier();
        int saveBonus = modifier + (isProficient ? proficientBonus : 0);
        int roll = Dice.rollD20(saveBonus);
        Dice.showRollResult("Dexterity Saving Throw", roll, "Roll (1d20" + formatModifier(saveBonus) + ")");
    }

    @FXML
    private void rollConCheckButtonAction() {
        int modifier = currentCharacter.getConstitutionModifier();
        int roll = Dice.rollD20(modifier);
        Dice.showRollResult("Constitution Check", roll, "Roll (1d20" + formatModifier(modifier) + ")");
    }

    @FXML
    private void rollConSaveButtonAction() {
        boolean isProficient = false; // Placeholder
        int proficientBonus = 2; // Placeholder
        int modifier = currentCharacter.getConstitutionModifier();
        int saveBonus = modifier + (isProficient ? proficientBonus : 0);
        int roll = Dice.rollD20(saveBonus);
        Dice.showRollResult("Constitution Saving Throw", roll, "Roll (1d20" + formatModifier(saveBonus) + ")");
    }

    @FXML
    private void rollIntCheckButtonAction() {
        int modifier = currentCharacter.getIntelligenceModifier();
        int roll = Dice.rollD20(modifier);
        Dice.showRollResult("Intelligence Check", roll, "Roll (1d20" + formatModifier(modifier) + ")");
    }

    @FXML
    private void rollIntSaveButtonAction() {
        boolean isProficient = false; // Placeholder
        int proficientBonus = 2; // Placeholder
        int modifier = currentCharacter.getIntelligenceModifier();
        int saveBonus = modifier + (isProficient ? proficientBonus : 0);
        int roll = Dice.rollD20(saveBonus);
        Dice.showRollResult("Intelligence Saving Throw", roll, "Roll (1d20" + formatModifier(saveBonus) + ")");
    }

    @FXML
    private void rollWisCheckButtonAction() {
        int modifier = currentCharacter.getWisdomModifier();
        int roll = Dice.rollD20(modifier);
        Dice.showRollResult("Wisdom Check", roll, "Roll (1d20" + formatModifier(modifier) + ")");
    }

    @FXML
    private void rollWisSaveButtonAction() {
        boolean isProficient = false; // Placeholder
        int proficientBonus = 2; // Placeholder
        int modifier = currentCharacter.getWisdomModifier();
        int saveBonus = modifier + (isProficient ? proficientBonus : 0);
        int roll = Dice.rollD20(saveBonus);
        Dice.showRollResult("Wisdom Saving Throw", roll, "Roll (1d20" + formatModifier(saveBonus) + ")");
    }

    @FXML
    private void rollChaCheckButtonAction() {
        int modifier = currentCharacter.getCharismaModifier();
        int roll = Dice.rollD20(modifier);
        Dice.showRollResult("Charisma Check", roll, "Roll (1d20" + formatModifier(modifier) + ")");
    }

    @FXML
    private void rollChaSaveButtonAction() {
        boolean isProficient = false; // Placeholder
        int proficientBonus = 2; // Placeholder
        int modifier = currentCharacter.getCharismaModifier();
        int saveBonus = modifier + (isProficient ? proficientBonus : 0);
        int roll = Dice.rollD20(saveBonus);
        Dice.showRollResult("Charisma Saving Throw", roll, "Roll (1d20" + formatModifier(saveBonus) + ")");
    }

    private void showNumberInputDialog(String title, String header, IntConsumer action) {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText("Amount: ");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(value -> {
            try {
                int amount = Integer.parseInt(value);
                if (amount > 0) {
                    action.accept(amount);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Please enter a positive number.");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Please enter a number.");
                alert.showAndWait();
            }
        });
    }

    public Character getCurrentCharacter() {
        return this.currentCharacter;
    }
}
