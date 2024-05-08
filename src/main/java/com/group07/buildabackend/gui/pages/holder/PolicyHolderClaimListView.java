package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.Component;

public class PolicyHolderClaimListView extends Component<PolicyHolderClaimListController> {
    public PolicyHolderClaimListView(String phId) {
        super(PolicyHolderClaimListView.class.getResource("PolicyHolderClaimListView.fxml"));
        controller.innitPage(phId);
    }
}
