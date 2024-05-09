package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class PolicyHolderClaimListView extends ControlledComponent<PolicyHolderClaimListController> {
    public PolicyHolderClaimListView(String phId) {
        super(PolicyHolderClaimListView.class.getResource("PolicyHolderClaimListView.fxml"));
        controller.innitPage(phId);
    }
}
