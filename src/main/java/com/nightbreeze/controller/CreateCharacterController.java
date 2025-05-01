package com.nightbreeze.controller;

import com.nightbreeze.model.Character;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateCharacterController implements Initializable {

    private Character character;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = new Character();
    }
}
