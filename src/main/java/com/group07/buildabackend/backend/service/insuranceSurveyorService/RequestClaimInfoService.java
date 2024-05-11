package com.group07.buildabackend.backend.service.insuranceSurveyorService;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.RequestClaimInfoDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.ProposeOperation;
import com.group07.buildabackend.backend.model.userAction.operations.RequestOperation;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import static com.group07.buildabackend.backend.service.Service.*;
import static com.group07.buildabackend.backend.service.insuranceSurveyorService.InsuranceSurveyorService.insuranceClaimRepository;

public class RequestClaimInfoService {
    public static Response<InsuranceClaim> requestClaimInfo(RequestClaimInfoDTO dto) {
        Response<InsuranceClaim> response = new Response<>(null);
        String claimId = dto.getClaimId();
        String notes = dto.getNotes();
        OperationType userAction = new ClaimAction(new RequestOperation());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try {
            InsuranceClaim claim = insuranceClaimRepository.retrieveActorById(claimId);

            if (claim == null) {
                throw new InvalidInputException("Claim not found", 404);
            }

            if (claim.getStatus() != InsuranceClaimStatus.NEW) {
                throw new InvalidInputException("Can not request this claim.", 400);
            }

            claim.setNote(notes);
            claim.setStatus(InsuranceClaimStatus.INFO_MISSING);

            insuranceClaimRepository.update(claim);

            handleSuccess(response, "Successfully requested info", 200, claim);


        } catch(InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());
        }

        return response;
    }


}

