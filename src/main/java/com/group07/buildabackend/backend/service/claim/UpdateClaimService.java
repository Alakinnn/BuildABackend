package com.group07.buildabackend.backend.service.claim;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.UpdateClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.UpdateOperation;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.service.Service;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class UpdateClaimService extends Service {
    public static Response<InsuranceClaim> updateClaim(UpdateClaimDTO dto) {
        Response<InsuranceClaim> response = new Response<>(null);
        OperationType userAction = new ClaimAction(new UpdateOperation());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try{
            ClaimRepository repo = new ClaimRepository();
            InsuranceClaim claim = repo.retrieveActorById(dto.getClaimId());

            if(claim == null){
                throw new InvalidInputException("Insurance claim not found", 404);
            }

            claim.setAmount(dto.getClaimAmount());
            claim.setExamDate(dto.getExamDate());
            claim.setReceiverBankName(dto.getBankName());
            claim.setReceiverBankNumber(dto.getAccountNumber());
            claim.setReceiverName(dto.getReceiverName());

            repo.update(claim);
            handleSuccess(response, "Successfully updated claim", 200, claim);
        } catch (InvalidInputException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
        }

        return response;
    }
}


