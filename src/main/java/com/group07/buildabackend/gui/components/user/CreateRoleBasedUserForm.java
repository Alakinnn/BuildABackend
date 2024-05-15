package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.user.controllers.CreateRoleBasedUserFormController;

public class CreateRoleBasedUserForm extends ControlledComponent<CreateRoleBasedUserFormController> {
    public CreateRoleBasedUserForm() {
        super(CreateRoleBasedUserForm.class.getResource("CreateRoleBasedUserForm.fxml"));
    }
}
