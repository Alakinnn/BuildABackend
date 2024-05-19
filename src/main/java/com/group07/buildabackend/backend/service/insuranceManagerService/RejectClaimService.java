package com.group07.buildabackend.backend.service.insuranceManagerService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.RejectOperation;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class RejectClaimService extends InsuranceManagerService {
    public static Response<InsuranceClaim> rejectClaim(String claimId) {
        Response<InsuranceClaim> response = new Response<>(null);
        OperationType userAction = new ClaimAction(new RejectOperation());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try {
            InsuranceClaim claim = insuranceClaimRepository.retrieveActorById(claimId);

            if(claim == null){
                throw new InvalidInputException("Claim not found", 400);
            }

            if (claim.getStatus() != InsuranceClaimStatus.PROPOSED) {
                throw new InvalidInputException("Can not reject this claim.", 400);
            }

            claim.setStatus(InsuranceClaimStatus.REJECTED);

            insuranceClaimRepository.update(claim);

            handleSuccess(response, "Successfully rejected claim", 200, claim);

        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
        }

        return response;
    }
}
