package com.group07.buildabackend.backend.service.insuranceSurveyorService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class ProposeClaimService extends InsuranceSurveyorService {
    public static Response<InsuranceClaim> proposeClaim(String claimId){
        Response<InsuranceClaim> response = new Response<>(null);
        try {
            InsuranceClaim claim = insuranceClaimRepository.retrieveById(claimId);

            if(claim == null){
                throw new InvalidInputException("Claim not found", 400);
            }

            claim.setStatus(InsuranceClaimStatus.PROPOSED);
            insuranceClaimRepository.update(claim);
            response.setData(claim);
            response.setResponseMsg("Successfully proposed claim!");
            response.setStatusCode(200);
        } catch (InvalidInputException e) {
            response.setStatusCode(e.getErrorCode());
            response.setResponseMsg(e.getMessage());
        }

        return response;
    }
}
