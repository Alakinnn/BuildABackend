package com.group07.buildabackend.backend.service.insuranceSurveyorService;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.InsuranceSurveyorRepository;
import com.group07.buildabackend.backend.service.Service;

public abstract class InsuranceSurveyorService extends Service {
    static final InsuranceSurveyorRepository<InsuranceSurveyor> insuranceSurveyorRepository = new InsuranceSurveyorRepository<>();
    static final ClaimRepository<InsuranceClaim> insuranceClaimRepository = new ClaimRepository<>();
}
