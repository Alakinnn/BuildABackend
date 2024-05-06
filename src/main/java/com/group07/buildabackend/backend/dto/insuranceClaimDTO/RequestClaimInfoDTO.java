package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

public class RequestClaimInfoDTO {
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
