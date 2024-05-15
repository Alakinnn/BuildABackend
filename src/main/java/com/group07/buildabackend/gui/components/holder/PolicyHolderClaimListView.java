package com.group07.buildabackend.gui.components.holder;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.holder.controllers.PolicyHolderClaimListController;

public class PolicyHolderClaimListView extends ControlledComponent<PolicyHolderClaimListController> {
    public PolicyHolderClaimListView(String phId) {
        super(PolicyHolderClaimListView.class.getResource("PolicyHolderClaimListView.fxml"));
        controller.innitPage(phId);
    }
}
