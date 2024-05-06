package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

import java.io.File;
import java.util.List;

public class AddClaimInfoDTO {
    private String claimId;
    private List<File> documents;

    public AddClaimInfoDTO() {
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public List<File> getDocuments() {
        return documents;
    }

    public void setDocuments(List<File> documents) {
        this.documents = documents;
    }
}
