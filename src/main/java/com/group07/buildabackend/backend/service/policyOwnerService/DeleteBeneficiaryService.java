package com.group07.buildabackend.backend.service.policyOwnerService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.userAction.actions.SystemUserAction;
import com.group07.buildabackend.backend.model.userAction.operations.DeleteOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.service.user.SystemUserService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class DeleteBeneficiaryService extends SystemUserService {
    public static Response<Beneficiary> deleteBeneficiary(String beneficiaryId) {
        Response<Beneficiary> response = new Response<>(null);
        try {

            Beneficiary beneficiary = policyOwnerRepository.retrieveOneBeneficiary(beneficiaryId, CurrentUserManager.getCurrentUser().getUserId());

            if (beneficiary == null) {
                throw new InvalidInputException("Beneficiary not found", 404);
            }

            OperationType userAction = new SystemUserAction(new DeleteOperation(), beneficiary.getUserType());
            String actionDescription = userAction.getDescription();
            response.setAction(actionDescription);

            beneficiaryRepository.delete(beneficiary);

            handleSuccess(response, "Successfully deleted beneficiary", 200, beneficiary);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
        }
        return response;
    }
}
