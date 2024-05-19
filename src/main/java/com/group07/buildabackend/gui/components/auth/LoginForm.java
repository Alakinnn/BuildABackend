package com.group07.buildabackend.gui.components.auth;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.auth.controllers.LoginFormController;

public class LoginForm extends ControlledComponent<LoginFormController> {
    public LoginForm() {
        super(LoginForm.class.getResource("LoginForm.fxml"));
    }
}
