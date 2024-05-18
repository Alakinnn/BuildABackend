package com.group07.buildabackend.gui.components.admin;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.admin.controllers.SystemAdminCreateDependentFormController;

public class SystemAdminCreateDependentForm extends ControlledComponent<SystemAdminCreateDependentFormController> {
    public SystemAdminCreateDependentForm() {
        super(SystemAdminCreateDependentForm.class.getResource("SystemAdminCreateDependentForm.fxml"));
    }
}
