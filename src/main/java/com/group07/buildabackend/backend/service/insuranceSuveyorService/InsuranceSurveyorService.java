package com.group07.buildabackend.backend.service.insuranceSuveyorService;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.InsuranceSurveyorRepository;

public abstract class InsuranceSurveyorService {
    static final InsuranceSurveyorRepository<InsuranceSurveyor> insuranceSurveyorRepository = new InsuranceSurveyorRepository<>();
    static final ClaimRepository<InsuranceClaim> insuranceClaimRepository = new ClaimRepository<>();
}
