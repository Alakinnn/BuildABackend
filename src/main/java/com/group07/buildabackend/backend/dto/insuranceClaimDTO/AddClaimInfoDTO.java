package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.DTO;

import java.io.File;
import java.util.List;

public class AddClaimInfoDTO implements DTO {
    private String id;
    private List<File> documents;

    public AddClaimInfoDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<File> getDocuments() {
        return documents;
    }

    public void setDocuments(List<File> documents) {
        this.documents = documents;
    }
}
