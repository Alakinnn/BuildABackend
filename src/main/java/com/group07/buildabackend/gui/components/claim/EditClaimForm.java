package com.group07.buildabackend.gui.components.claim;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.claim.controllers.EditClaimFormController;

public class EditClaimForm extends ControlledComponent<EditClaimFormController> {
    public EditClaimForm(String claimId) {
        super(EditClaimForm.class.getResource("EditClaimForm.fxml"));
        controller.initPage(claimId);
    }
}
