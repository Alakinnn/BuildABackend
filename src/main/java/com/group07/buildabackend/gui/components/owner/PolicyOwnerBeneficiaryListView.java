package com.group07.buildabackend.gui.components.owner;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.owner.controllers.PolicyOwnerBeneficiaryListViewController;

public class PolicyOwnerBeneficiaryListView extends ControlledComponent<PolicyOwnerBeneficiaryListViewController> {
    public PolicyOwnerBeneficiaryListView(String poId) {
        super(PolicyOwnerBeneficiaryListView.class.getResource("PolicyOwnerBeneficiaryListView.fxml"));
        controller.initPage(poId);
    }
}
