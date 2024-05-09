package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class AddClaimInfoForm extends ControlledComponent<AddClaimInfoFormController> {
    public AddClaimInfoForm(String claimId) {
        super(AddClaimInfoForm.class.getResource("AddClaimInfoForm.fxml"));
        controller.initPage(claimId);
    }
}
