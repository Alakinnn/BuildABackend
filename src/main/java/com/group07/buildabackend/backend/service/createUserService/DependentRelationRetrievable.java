package com.group07.buildabackend.backend.service.createUserService;


public interface DependentRelationRetrievable extends PolicyHolderRelationRetrievable {
    com.group07.buildabackend.backend.model.customer.PolicyHolder retrievePolicyHolder(String policyHolderId);
}
