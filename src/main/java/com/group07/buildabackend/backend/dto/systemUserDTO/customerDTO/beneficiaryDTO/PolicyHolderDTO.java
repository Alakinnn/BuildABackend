package com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.DTO;
import com.group07.buildabackend.backend.dto.authenticationDTO.RegisterInfoDTO;

public class PolicyHolderDTO extends RegisterInfoDTO implements DTO {
    private String policyOwnerId;
    public PolicyHolderDTO() {
    }

    public String getPolicyOwnerId() {
        return policyOwnerId;
    }

    public void setPolicyOwnerId(String policyOwnerId) {
        this.policyOwnerId = policyOwnerId;
    }
}
