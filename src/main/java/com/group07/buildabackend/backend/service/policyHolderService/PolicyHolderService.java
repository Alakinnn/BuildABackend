package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.service.Service;

public abstract class PolicyHolderService extends Service {
    static final PolicyHolderRepository<PolicyHolder> holderRepository = new PolicyHolderRepository<>();
    static final ClaimRepository<InsuranceClaim> insuranceClaimRepository = new ClaimRepository<>();





}
