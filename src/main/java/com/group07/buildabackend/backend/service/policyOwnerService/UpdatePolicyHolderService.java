package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.userAction.actions.UserAction;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.UpdateOperation;
import com.group07.buildabackend.backend.service.SystemUserService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class UpdatePolicyHolderService extends SystemUserService {
    public static Response<PolicyHolder> updatePolicyHolder(PolicyHolderDTO dto){
        Response<PolicyHolder> response = new Response(null);

        OperationType userAction = new UserAction(new UpdateOperation(), SystemUserType.policy_holder);
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try{
            PolicyOwner policyOwner = policyOwnerRepository.retrieveActorById(dto.getPolicyOwnerId());

            if(policyOwner == null){
                throw new InvalidInputException("Policy owner not found", 400);
            }

            PolicyHolder policyHolder = PolicyHolderMapper.toEntity(dto);

            policyHolder.setPhone(dto.getPhone());
            policyHolder.setAddress(dto.getAddress());
            policyHolder.setEmail(dto.getEmail());
            policyHolder.setFirstName(dto.getFirstName());
            policyHolder.setLastName(dto.getLastName());

            Credentials credentials = createCredentials(dto.getPwd(), policyHolder);
            policyHolder.setCredentials(credentials);

            systemUserRepository.update(policyHolder);
            handleSuccess(response, "Successfully update policy holder", 200, policyHolder);
        } catch (InvalidInputException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (InvalidCredentialsException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        }

        return response;
    }
}
