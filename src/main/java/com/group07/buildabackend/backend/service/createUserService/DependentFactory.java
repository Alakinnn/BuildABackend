package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;


public interface DependentFactory extends PolicyHolderFactory{
    PolicyHolder retrievePolicyHolder(String policyHolderId);
}
