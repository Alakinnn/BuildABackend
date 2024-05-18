package com.group07.buildabackend.gui.components.admin;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.admin.controllers.SystemAdminCreateHolderFormController;

public class SystemAdminCreateHolderForm extends ControlledComponent<SystemAdminCreateHolderFormController> {
    public SystemAdminCreateHolderForm() {
        super(SystemAdminCreateHolderForm.class.getResource("SystemAdminCreateHolderForm.fxml"));
    }
}
