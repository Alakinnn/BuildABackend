package com.group07.buildabackend.backend.dto.beneficiaryDTO;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;

public class PolicyHolderMapper {
    public static PolicyHolder toEntity(PolicyHolderDTO policyHolderDTO) {
        PolicyHolder policyHolder = new PolicyHolder();
        policyHolder.setEmail(policyHolderDTO.getEmail());
        policyHolder.setPhone(policyHolderDTO.getPhone());
        policyHolder.setLastName(policyHolderDTO.getLastName());
        policyHolder.setFirstName(policyHolderDTO.getFirstName());
        policyHolder.setAddress(policyHolderDTO.getAddress());
        return policyHolder;
    }
}
