package com.group07.buildabackend.gui.components.holder;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.holder.controllers.AddClaimInfoFormController;

public class AddClaimInfoForm extends ControlledComponent<AddClaimInfoFormController> {
    public AddClaimInfoForm(String claimId) {
        super(AddClaimInfoForm.class.getResource("AddClaimInfoForm.fxml"));
        controller.initPage(claimId);
    }
}
