package com.group07.buildabackend.backend.service.policyOwnerService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.DeleteOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;

import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class DeleteBeneficiaryClaimService extends PolicyOwnerService {
    public static Response<InsuranceClaim> deleteBeneficiaryClaim(String claimId, String beneficiaryId) {
        Response<InsuranceClaim> response = new Response<>(null);
        OperationType userAction = new ClaimAction(new DeleteOperation());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try {
            InsuranceClaim insuranceClaim = policyOwnerRepository.retrieveOneBeneficiaryClaim(claimId, CurrentUserManager.getCurrentUser().getUserId(), beneficiaryId);
            if (insuranceClaim == null) {
                throw new InvalidInputException("Claim not found", 404);
            }

            insuranceClaimRepository.delete(insuranceClaim);
            handleSuccess(response, "Successfully deleted claim", 200, insuranceClaim);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
        }
        return response;
    }
}
