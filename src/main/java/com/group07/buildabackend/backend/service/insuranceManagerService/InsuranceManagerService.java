package com.group07.buildabackend.backend.service.insuranceManagerService;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.service.Service;

public abstract class InsuranceManagerService extends Service {
    static final ClaimRepository<InsuranceClaim> insuranceClaimRepository = new ClaimRepository<>();
}
