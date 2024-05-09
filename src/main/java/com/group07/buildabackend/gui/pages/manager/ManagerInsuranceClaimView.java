package com.group07.buildabackend.gui.pages.manager;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class ManagerInsuranceClaimView extends ControlledComponent<ManagerInsuranceClaimViewController> {
    public ManagerInsuranceClaimView(String claimId) {
        super(ManagerInsuranceClaimView.class.getResource("ManagerInsuranceClaimView.fxml"));
        controller.setClaimId(claimId);
    }
}
