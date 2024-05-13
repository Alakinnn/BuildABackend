package com.group07.buildabackend.gui.pages.owner;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class PolicyOwnerClaimListView extends ControlledComponent<PolicyOwnerClaimListController> {
    public PolicyOwnerClaimListView(String policyOwnerId) {
        super(PolicyOwnerClaimListView.class.getResource("PolicyOwnerClaimListView.fxml"));
        controller.initPage(policyOwnerId);
    }
}
