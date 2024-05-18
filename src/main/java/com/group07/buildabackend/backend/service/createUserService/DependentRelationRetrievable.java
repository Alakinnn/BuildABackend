package com.group07.buildabackend.backend.service.createUserService;
/**
 * @author Group_7
 */

public interface DependentRelationRetrievable extends PolicyHolderRelationRetrievable {
    com.group07.buildabackend.backend.model.customer.PolicyHolder retrievePolicyHolder(String policyHolderId);
}
