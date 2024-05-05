package com.group07.buildabackend.backend.service.insuranceSurveyorService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.RequestClaimInfoDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import static com.group07.buildabackend.backend.service.insuranceSurveyorService.InsuranceSurveyorService.insuranceClaimRepository;

public class RequestClaimInfoService {
    public static Response<InsuranceClaim> requestClaimInfo(RequestClaimInfoDTO dto) {
        Response<InsuranceClaim> response = new Response<>(null);
        String claimId = dto.getClaimId();
        String notes = dto.getNotes();

        try {
            InsuranceClaim claim = insuranceClaimRepository.retrieveById(claimId);

            if (claim == null) {
                throw new InvalidInputException("Claim not found", 400);
            }

            claim.setNote(notes);
            claim.setStatus(InsuranceClaimStatus.INFO_MISSING);

            insuranceClaimRepository.update(claim);

            response.setData(claim);
            response.setResponseMsg("Successfully requested claim info!");
            response.setStatusCode(200);

        } catch(InvalidInputException e) {
            response.setStatusCode(e.getErrorCode());
            response.setResponseMsg(e.getMessage());
        } catch (Exception e) {
            response.setResponseMsg(e.getMessage());
        }

        return response;
    }


}

