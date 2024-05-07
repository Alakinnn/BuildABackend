package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

import com.group07.buildabackend.backend.dto.DTO;

public class ProposeClaimDTO implements DTO {
    private String id;

    public ProposeClaimDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
