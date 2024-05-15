package com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO;

import com.group07.buildabackend.backend.dto.DTO;
import com.group07.buildabackend.backend.dto.authenticationDTO.RegisterInfoDTO;

public class DependentDTO extends RegisterInfoDTO implements DTO {
    private String policyHolderId;
    public DependentDTO() {
    }
    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(String policyHolderId) {
        this.policyHolderId = policyHolderId;
    }
}
