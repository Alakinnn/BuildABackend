package com.group07.buildabackend.backend.service;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.InsuranceSurveyorRepository;

public class InsuranceSurveyorService {
    private final InsuranceSurveyorRepository<InsuranceSurveyor> insuranceSurveyorRepository = new InsuranceSurveyorRepository<>();
    private final ClaimRepository<InsuranceClaim> insuranceClaimClaimRepository = new ClaimRepository<>();

    public InsuranceSurveyorService() {
    }

    public InsuranceClaim requestClaimInfo(String claimId, String notes){
        InsuranceClaim claim = insuranceClaimClaimRepository.retrieveById(claimId);

        if(claim == null){
            //EXCEPTION HERE
        }

        claim.setNotes(notes);
        insuranceClaimClaimRepository.update(claim);
        return claim;
    }
}
