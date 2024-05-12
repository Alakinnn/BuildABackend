package com.group07.buildabackend.gui.pages.dependent;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.pages.user.CreateUserForm;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateDependentFormController implements ComponentController, Initializable {
    @FXML
    private ChoiceBox<ChoiceField<String>> policyHolderChoice;

    @FXML
    private HBox createUserFormContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createUserFormContainer.getChildren().add(new CreateUserForm().getRoot());
    }

    public void presetPolicyHolderId(String phId) {
        policyHolderChoice.setValue(new ChoiceField<>("Myself", phId));
        policyHolderChoice.setDisable(true);
    }
}
