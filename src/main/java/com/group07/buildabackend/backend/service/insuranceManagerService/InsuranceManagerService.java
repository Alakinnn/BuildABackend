package com.group07.buildabackend.backend.service.insuranceManagerService;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;

public abstract class InsuranceManagerService {
    static final ClaimRepository<InsuranceClaim> insuranceClaimRepository = new ClaimRepository<>();
}
