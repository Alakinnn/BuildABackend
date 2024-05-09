package com.group07.buildabackend.gui.pages.dependent;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class DependentClaimListView extends ControlledComponent<DependentClaimListController> {
    public DependentClaimListView(String dId) {
        super(DependentClaimListView.class.getResource("DependentClaimListView.fxml"));
        controller.innitPage(dId);
    }
}
