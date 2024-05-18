package com.group07.buildabackend.gui.components.user.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormPasswordField;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUserFormController extends FormController<SystemUser> implements ComponentController, Initializable {
    @FXML
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public TextField emailField;
    @FXML
    public TextField phoneField;
    @FXML
    public TextField addressField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField confirmPasswordField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addRequiredField(new FormTextField(firstNameField, "First Name"));
        addRequiredField(new FormTextField(lastNameField, "Last Name"));
        addRequiredField(new FormTextField(emailField, "Email"));
        addRequiredField(new FormTextField(phoneField, "Phone Number"));
        addRequiredField(new FormTextField(addressField, "Address"));
        addRequiredField(new FormPasswordField(passwordField, "Password"));
        addRequiredField(new FormPasswordField(confirmPasswordField, "Confirm Password"));
    }

    @Override
    public Response<SystemUser> sendFormRequest() {
        return null;
    }


}
