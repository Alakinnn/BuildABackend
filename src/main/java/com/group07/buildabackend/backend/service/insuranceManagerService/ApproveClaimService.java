package com.group07.buildabackend.backend.service.insuranceManagerService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class ApproveClaimService extends InsuranceManagerService {
    public static Response<InsuranceClaim> approveClaim(String claimId) {
        Response<InsuranceClaim> response = new Response<>(null);
        try {
            InsuranceClaim claim = insuranceClaimRepository.retrieveActorById(claimId);

            if(claim == null){
                throw new InvalidInputException("Claim not found", 400);
            }

            if (claim.getStatus() != InsuranceClaimStatus.PROPOSED) {
                throw new InvalidInputException("Can not approve this claim.", 400);
            }

            claim.setStatus(InsuranceClaimStatus.APPROVED);
            insuranceClaimRepository.update(claim);
            handleSuccess(response, "Successfully approved claim", 200, claim);

        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        }

        return response;
    }
}