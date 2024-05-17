package com.group07.buildabackend.gui.components.admin;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.admin.controllers.SystemAdminCreateOtherUserFormController;

public class SystemAdminCreateOtherUserForm extends ControlledComponent<SystemAdminCreateOtherUserFormController> {
    public SystemAdminCreateOtherUserForm() {
        super(SystemAdminCreateOtherUserForm.class.getResource("SystemAdminCreateOtherUserForm.fxml"));
    }
}
