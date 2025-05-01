package com.nightbreeze.controller;

import com.nightbreeze.model.Character;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateCharacterController implements Initializable {

    @FXML private TextField characterName;
    @FXML private TextField characterClass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
