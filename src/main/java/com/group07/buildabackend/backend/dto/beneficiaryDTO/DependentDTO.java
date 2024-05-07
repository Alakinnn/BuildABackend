package com.group07.buildabackend.backend.dto.beneficiaryDTO;

import com.group07.buildabackend.backend.dto.DTO;
import com.group07.buildabackend.backend.dto.authenticationDTO.RegisterInfoDTO;

public class DependentDTO extends RegisterInfoDTO implements DTO {
    private String policyHolderId;
    private String policyOwnerId;
    public DependentDTO() {
    }
    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(String policyHolderId) {
        this.policyHolderId = policyHolderId;
    }

    public String getPolicyOwnerId() {
        return policyOwnerId;
    }

    public void setPolicyOwnerId(String policyOwnerId) {
        this.policyOwnerId = policyOwnerId;
    }
}
