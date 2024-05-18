package com.group07.buildabackend.gui.components.holder;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.holder.controllers.PolicyHolderDependentListController;

public class PolicyHolderDependentList extends ControlledComponent<PolicyHolderDependentListController> {
    public PolicyHolderDependentList(String phId) {
        super(PolicyHolderDependentList.class.getResource("PolicyHolderDependentList.fxml"));
        controller.initPage(phId);
    }
}
