package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class PolicyHolderDependentList extends ControlledComponent<PolicyHolderDependentListController> {
    public PolicyHolderDependentList(String phId) {
        super(PolicyHolderDependentList.class.getResource("PolicyHolderDependentList.fxml"));
        controller.initPage(phId);
    }
}
