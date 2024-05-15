package com.group07.buildabackend.gui.components.holder;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.holder.controllers.PolicyHolderDependentListController;

public class PolicyHolderDependentList extends ControlledComponent<PolicyHolderDependentListController> {
    public PolicyHolderDependentList(String phId) {
        super(PolicyHolderDependentList.class.getResource("PolicyHolderDependentList.fxml"));
        controller.initPage(phId);
    }
}
