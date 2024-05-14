package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class EditClaimForm extends ControlledComponent<EditClaimFormController> {
    public EditClaimForm(String claimId) {
        super(EditClaimForm.class.getResource("EditClaimForm.fxml"));
        controller.initPage(claimId);
    }
}
