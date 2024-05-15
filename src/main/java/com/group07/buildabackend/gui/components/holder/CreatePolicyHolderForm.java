package com.group07.buildabackend.gui.components.holder;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.holder.controllers.CreatePolicyHolderFormController;

public class CreatePolicyHolderForm extends ControlledComponent<CreatePolicyHolderFormController> {
    public CreatePolicyHolderForm() {
        super(CreatePolicyHolderForm.class.getResource("CreatePolicyHolderForm.fxml"));
    }
}
