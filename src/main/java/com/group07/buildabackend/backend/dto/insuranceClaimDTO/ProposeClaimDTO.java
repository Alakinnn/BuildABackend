package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

import com.group07.buildabackend.backend.dto.DTO;

public class ProposeClaimDTO implements DTO {
    private String claimId;

    public ProposeClaimDTO() {
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }
}
