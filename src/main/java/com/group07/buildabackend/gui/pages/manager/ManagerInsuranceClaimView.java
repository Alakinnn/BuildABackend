package com.group07.buildabackend.gui.pages.manager;

import com.group07.buildabackend.gui.components.Component;

public class ManagerInsuranceClaimView extends Component<ManagerInsuranceClaimViewController> {
    public ManagerInsuranceClaimView(String claimId) {
        super(ManagerInsuranceClaimView.class.getResource("ManagerInsuranceClaimView.fxml"));
        controller.setClaimId(claimId);
    }
}
