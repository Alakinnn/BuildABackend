package com.group07.buildabackend.gui.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClaimAddInfoRequest {
    private String claimId;

    private List<File> documents;

    public ClaimAddInfoRequest() {
        documents = new ArrayList<>();
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
