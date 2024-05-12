package com.group07.buildabackend.gui.pages.auth;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.authentication.service.LoginService;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormPasswordField;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.utils.AlertManager;
import com.group07.buildabackend.gui.utils.FormSubmitter;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
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
    public Response<SystemUser> sendRequest() {
        // TODO: Please move this service to a AuthController or UserController
        LoginInfoDTO dto = new LoginInfoDTO();
        dto.setEmail(emailField.getText());
        dto.setPwd(passwordField.getText());

        Response<SystemUser> res = LoginService.login(dto);

        return res;
    }

    private Object goToDefaultPage() {
        Page page = PageFactoryManager.getFactory().createDefaultPage();
        SceneManager.getInstance().switchToPage(page);
        return null;
    }

    @Override
    public void onSubmit(ActionEvent event) {
        try {
            checkRequiredFields();
            FormSubmitter submitter = new FormSubmitter();
            submitter.onSubmit(this::sendRequest, this::goToDefaultPage);
        } catch (Exception e) {
            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }
    }
}
