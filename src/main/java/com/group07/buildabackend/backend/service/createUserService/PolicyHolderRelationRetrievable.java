package com.group07.buildabackend.backend.service.createUserService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.customer.PolicyOwner;

public interface PolicyHolderRelationRetrievable {
    PolicyOwner retrievePolicyOwner(String policyOwnerId);
}
