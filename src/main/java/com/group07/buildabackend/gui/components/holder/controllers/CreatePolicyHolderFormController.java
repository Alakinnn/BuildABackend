package com.group07.buildabackend.gui.components.holder.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.user.CreateUserForm;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CreatePolicyHolderFormController implements ComponentController, Initializable {
    @FXML
    private ChoiceBox<String> policyOwnerChoice;
    @FXML
    private HBox createUserFormContainer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createUserFormContainer.getChildren().add(new CreateUserForm().getRoot());
    }
}
