package com.group07.buildabackend.backend.service.policyOwnerService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimMapper;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.UpdateOperation;
import com.group07.buildabackend.backend.service.Service;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.time.LocalDate;

public class UpdatePolicyHolderClaimService extends Service {
    public static Response<InsuranceClaim> updatePolicyHolderClaim(InsuranceClaimDTO insuranceClaimDTO){
        Response<InsuranceClaim> response = new Response<>(null);
        OperationType userAction = new ClaimAction(new UpdateOperation());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try{
            PolicyHolder policyHolder = policyHolderRepository.retrieveActorById(insuranceClaimDTO.getCustomerId());

            if(policyHolder == null){
                throw new InvalidInputException("Policy holder not found", 400);
            }

            InsuranceClaim selfClaim = policyHolderRepository.retrieveOneClaimByActorId(insuranceClaimDTO.getId(), insuranceClaimDTO.getCustomerId());

            if(selfClaim == null){
                throw new InvalidInputException("Insurance claim not found", 400);
            }

            InsuranceClaim updatedClaim = InsuranceClaimMapper.toEntity(insuranceClaimDTO);

            updatedClaim.setAmount(insuranceClaimDTO.getAmount());
            updatedClaim.setClaimDate(LocalDate.parse(insuranceClaimDTO.getClaimDate()));
            updatedClaim.setReceiverBankName(insuranceClaimDTO.getReceiverBankName());
            updatedClaim.setReceiverBankNumber(insuranceClaimDTO.getReceiverBankNumber());
            updatedClaim.setReceiverName(insuranceClaimDTO.getReceiverName());

            insuranceClaimRepository.update(updatedClaim);
            handleSuccess(response, "Successfully updated claim", 200, updatedClaim);
        } catch (InvalidInputException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
        }

        return response;
    }
}
