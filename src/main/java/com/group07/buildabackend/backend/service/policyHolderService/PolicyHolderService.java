package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;

public abstract class PolicyHolderService {
    private static final PolicyHolderRepository<PolicyHolder> holderRepository = new PolicyHolderRepository<>();
    private static final ClaimRepository<InsuranceClaim> insuranceClaimRepository = new ClaimRepository<>();

    public static PolicyHolderRepository<PolicyHolder> getHolderRepository() {
        return holderRepository;
    }

    public static ClaimRepository<InsuranceClaim> getInsuranceClaimRepository() {
        return insuranceClaimRepository;
    }




}
