package com.group07.buildabackend.gui.components.manager;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.manager.controllers.InsuranceManagerClaimListViewController;

public class InsuranceManagerClaimListView extends ControlledComponent<InsuranceManagerClaimListViewController> {
    public InsuranceManagerClaimListView() {
        super(InsuranceManagerClaimListView.class.getResource("InsuranceManagerClaimListView.fxml"));
    }
}
