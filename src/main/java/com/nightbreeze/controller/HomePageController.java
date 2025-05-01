package com.nightbreeze.controller;

import com.nightbreeze.model.Character;
import com.nightbreeze.util.DataHelper;
import com.nightbreeze.util.GUIManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController implements Initializable {

    @FXML
    private Button characterButton;

    Character currentCharacter;

    @FXML
    public void characterButtonAction(ActionEvent event) throws IOException {
        if (currentCharacter == null) {
            Parent root = GUIManager.loadFXML("create-character");
//            GUIManager.loadStage("create-character");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = stage.getScene();
            scene.setRoot(root);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentCharacter = DataHelper.loadCharacterData();

        if (currentCharacter == null) {
            characterButton.setText("Create a new Character");
            System.out.println("Characters' file empty.");
        } else {
            characterButton.setText("Characters' file not empty.");
            System.out.println("Loaded character: " + currentCharacter.getName());
        }
    }
}
