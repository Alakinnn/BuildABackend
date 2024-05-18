package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.DTO;

public class RequestClaimInfoDTO implements DTO {
    private String claimId;
    private String notes;

    public RequestClaimInfoDTO() {
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
