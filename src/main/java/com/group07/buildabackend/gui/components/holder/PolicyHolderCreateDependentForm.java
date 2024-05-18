package com.group07.buildabackend.gui.components.holder;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.holder.controllers.PolicyHolderCreateDependentFormController;

public class PolicyHolderCreateDependentForm extends ControlledComponent<PolicyHolderCreateDependentFormController> {
    public PolicyHolderCreateDependentForm(String phId) {
        super(PolicyHolderCreateDependentForm.class.getResource("PolicyHolderCreateDependentForm.fxml"));
        controller.presetPolicyHolderId(phId);
    }
}
