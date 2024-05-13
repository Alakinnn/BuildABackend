package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ControlledComponent;

import java.util.List;

public class ClaimList extends ControlledComponent<ClaimListController> {
    public ClaimList() {
        super(ClaimList.class.getResource("ClaimList.fxml"));
    }

    public void addClaim(InsuranceClaim claim) {
        controller.addClaim(claim);
    }

    public void addAllClaims(List<InsuranceClaim> claims) {
        controller.addAllClaims(claims);
    }
    public void resetClaims() {
        controller.resetClaims();
    }
}
