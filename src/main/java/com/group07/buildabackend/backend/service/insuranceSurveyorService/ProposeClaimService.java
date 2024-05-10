package com.group07.buildabackend.backend.service.insuranceSurveyorService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.ProposeClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class ProposeClaimService extends InsuranceSurveyorService {
    public static Response<InsuranceClaim> proposeClaim(ProposeClaimDTO dto){
        Response<InsuranceClaim> response = new Response<>(null);
        String claimId = dto.getId();
        try {
            InsuranceClaim claim = insuranceClaimRepository.retrieveActorById(claimId);

            if(claim == null){
                throw new InvalidInputException("Claim not found", 404);
            }

            if (claim.getStatus() != InsuranceClaimStatus.NEW) {
                throw new InvalidInputException("Can not propose this claim.", 400);
            }

            claim.setStatus(InsuranceClaimStatus.PROPOSED);
            insuranceClaimRepository.update(claim);

            handleSuccess(response, "Successfully proposed claim", 200, claim);

        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        }

        return response;
    }
}