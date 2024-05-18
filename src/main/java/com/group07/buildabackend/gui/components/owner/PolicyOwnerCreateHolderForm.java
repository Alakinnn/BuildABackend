package com.group07.buildabackend.gui.components.owner;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.owner.controllers.PolicyOwnerCreateHolderFormController;

public class PolicyOwnerCreateHolderForm extends ControlledComponent<PolicyOwnerCreateHolderFormController> {
    public PolicyOwnerCreateHolderForm(String poId) {
        super(PolicyOwnerCreateHolderForm.class.getResource("PolicyOwnerCreateHolderForm.fxml"));
        controller.presetPolicyOwnerId(poId);
    }
}
