package com.group07.buildabackend.gui.pages.user;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class CreateUserForm extends ControlledComponent<CreateUserFormController> {
    public CreateUserForm() {
        super(CreateUserForm.class.getResource("CreateUserForm.fxml"));
    }
}
