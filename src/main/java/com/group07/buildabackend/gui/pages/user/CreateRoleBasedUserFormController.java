package com.group07.buildabackend.gui.pages.user;

import com.group07.buildabackend.gui.components.ComponentController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateRoleBasedUserFormController implements ComponentController, Initializable {
    @FXML
    private ChoiceBox<String> roleChoice;
    @FXML
    private HBox createUserFormContainer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createUserFormContainer.getChildren().add(new CreateUserForm().getRoot());
    }
}
