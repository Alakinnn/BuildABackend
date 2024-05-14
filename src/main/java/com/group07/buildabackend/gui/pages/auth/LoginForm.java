package com.group07.buildabackend.gui.pages.auth;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.gui.components.ControlledComponent;

public class LoginForm extends ControlledComponent<LoginFormController> {
    public LoginForm() {
        super(LoginForm.class.getResource("LoginForm.fxml"));
    }
}
