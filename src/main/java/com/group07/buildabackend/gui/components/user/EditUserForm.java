package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class EditUserForm extends ControlledComponent<EditUserFormController> {
    public EditUserForm(String userId) {
        super(EditUserForm.class.getResource("EditUserForm.fxml"));
        controller.initPage(userId);
    }
}
