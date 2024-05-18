package com.group07.buildabackend.gui.components.dependent;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.dependent.controllers.DependentClaimListController;

public class DependentClaimListView extends ControlledComponent<DependentClaimListController> {
    public DependentClaimListView(String dId) {
        super(DependentClaimListView.class.getResource("DependentClaimListView.fxml"));
        controller.innitPage(dId);
    }
}
