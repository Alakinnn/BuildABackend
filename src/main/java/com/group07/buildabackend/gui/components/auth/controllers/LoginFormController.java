package com.group07.buildabackend.gui.components.auth.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.AuthController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormPasswordField;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.components.nav.factories.NavBarFactoryManager;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.Page;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController extends FormController<SystemUser> implements ComponentController, Initializable {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addRequiredField(new FormTextField(emailField, "Email"));
        addRequiredField(new FormPasswordField(passwordField, "Password"));
    }

    @Override
    public Response<SystemUser> sendFormRequest() {
        AuthController controller = new AuthController();

        LoginInfoDTO dto = new LoginInfoDTO();
        dto.setEmail(emailField.getText());
        dto.setPwd(passwordField.getText());

        return controller.login(dto);
    }

    private Object goToDefaultPage() {
        Page page = PageFactoryManager.getFactory().createDefaultPage();
        SceneManager.getInstance().switchToPage(page);
        return null;
    }

    @Override
    public void onSuccessfulSubmit() {
        NavBarFactoryManager.refreshFactory();
        PageFactoryManager.refreshFactory();
        goToDefaultPage();
    }
}
