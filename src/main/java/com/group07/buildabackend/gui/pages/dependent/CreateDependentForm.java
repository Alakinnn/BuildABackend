package com.group07.buildabackend.gui.pages.dependent;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.ControlledComponent;

public class CreateDependentForm extends ControlledComponent<CreateDependentFormController> {
    public CreateDependentForm() {
        super(CreateDependentForm.class.getResource("CreateDependentForm.fxml"));
    }

    public CreateDependentForm(String phId) {
        super(CreateDependentForm.class.getResource("CreateDependentForm.fxml"));
        controller.presetPolicyHolderId(phId);
    }
}
