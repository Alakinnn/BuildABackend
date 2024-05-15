package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.user.controllers.CreateUserFormController;

public class CreateUserForm extends ControlledComponent<CreateUserFormController> {
    public CreateUserForm() {
        super(CreateUserForm.class.getResource("CreateUserForm.fxml"));
    }
}
