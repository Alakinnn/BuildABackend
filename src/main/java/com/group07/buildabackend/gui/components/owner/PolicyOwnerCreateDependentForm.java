package com.group07.buildabackend.gui.components.owner;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.owner.controllers.PolicyOwnerCreateDependentFormController;

public class PolicyOwnerCreateDependentForm extends ControlledComponent<PolicyOwnerCreateDependentFormController> {
    public PolicyOwnerCreateDependentForm(String poId) {
        super(PolicyOwnerCreateDependentForm.class.getResource("PolicyOwnerCreateDependentForm.fxml"));
        controller.initPage(poId);
    }
}
