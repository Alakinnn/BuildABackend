package com.group07.buildabackend.gui.components.dependent;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.dependent.controllers.CreateDependentFormController;

public class CreateDependentForm extends ControlledComponent<CreateDependentFormController> {
    public CreateDependentForm() {
        super(CreateDependentForm.class.getResource("CreateDependentForm.fxml"));
    }

    public CreateDependentForm(String phId) {
        super(CreateDependentForm.class.getResource("CreateDependentForm.fxml"));
        if (phId != null) {
            controller.presetPolicyHolderId(phId);
        }
    }
}
