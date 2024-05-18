package com.group07.buildabackend.gui.components.user;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.user.controllers.EditUserFormController;

public class EditUserForm extends ControlledComponent<EditUserFormController> {
    public EditUserForm(String userId) {
        super(EditUserForm.class.getResource("EditUserForm.fxml"));
        controller.initPage(userId);
    }
}
