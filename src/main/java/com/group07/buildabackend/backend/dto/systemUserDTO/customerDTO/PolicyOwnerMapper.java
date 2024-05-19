package com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.customer.PolicyOwner;

public class PolicyOwnerMapper {
    public static PolicyOwner toEntity(PolicyOwnerDTO policyOwnerDTO) {
        PolicyOwner policyOwner = new PolicyOwner();
        policyOwner.setEmail(policyOwnerDTO.getEmail());
        policyOwner.setPhone(policyOwnerDTO.getPhone());
        policyOwner.setLastName(policyOwnerDTO.getLastName());
        policyOwner.setFirstName(policyOwnerDTO.getFirstName());
        policyOwner.setAddress(policyOwnerDTO.getAddress());
        policyOwner.setYearlyRate(policyOwnerDTO.getYearlyRate());
        return policyOwner;
    }
}
