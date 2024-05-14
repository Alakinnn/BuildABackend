package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.model.customer.PolicyOwner;

public interface PolicyHolderFactory {
    PolicyOwner retrievePolicyOwner(String policyOwnerId);
}
