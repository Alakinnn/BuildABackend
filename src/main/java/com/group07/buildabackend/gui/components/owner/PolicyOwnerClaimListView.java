package com.group07.buildabackend.gui.components.owner;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.owner.controllers.PolicyOwnerClaimListController;

public class PolicyOwnerClaimListView extends ControlledComponent<PolicyOwnerClaimListController> {
    public PolicyOwnerClaimListView(String policyOwnerId) {
        super(PolicyOwnerClaimListView.class.getResource("PolicyOwnerClaimListView.fxml"));
        controller.initPage(policyOwnerId);
    }
}
