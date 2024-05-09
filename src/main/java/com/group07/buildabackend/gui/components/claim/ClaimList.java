package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ControlledComponent;

public class ClaimList extends ControlledComponent<ClaimListController> {
    public ClaimList() {
        super(ClaimList.class.getResource("ClaimList.fxml"));
    }

    public void addClaim(InsuranceClaim claim) {
        controller.addClaim(claim);
    }
}
