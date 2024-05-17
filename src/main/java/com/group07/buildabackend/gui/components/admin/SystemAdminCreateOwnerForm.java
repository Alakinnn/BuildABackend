package com.group07.buildabackend.gui.components.admin;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.admin.controllers.SystemAdminCreateOwnerFormController;

public class SystemAdminCreateOwnerForm extends ControlledComponent<SystemAdminCreateOwnerFormController> {
    public SystemAdminCreateOwnerForm() {
        super(SystemAdminCreateOwnerForm.class.getResource("SystemAdminCreateOwnerForm.fxml"));
    }
}
