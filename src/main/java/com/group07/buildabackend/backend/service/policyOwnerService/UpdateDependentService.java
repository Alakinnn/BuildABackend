package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.userAction.actions.UserAction;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.UpdateOperation;
import com.group07.buildabackend.backend.service.SystemUserService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class UpdateDependentService extends SystemUserService {
    public static Response<Dependent> policyOwnerUpdateDependent(DependentDTO dto){
        Response<Dependent> response = new Response(null);
        OperationType userAction = new UserAction(new UpdateOperation(), SystemUserType.dependent);
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try{
            PolicyOwner policyOwner = policyOwnerRepository.retrieveActorById(dto.getPolicyOwnerId());

            if(policyOwner == null){
                throw new InvalidInputException("Policy owner not found", 400);
            }

            Dependent dependent = DependentMapper.toEntity(dto);

            dependent.setPhone(dto.getPhone());
            dependent.setAddress(dto.getAddress());
            dependent.setEmail(dto.getEmail());
            dependent.setFirstName(dto.getFirstName());
            dependent.setLastName(dto.getLastName());

            Credentials credentials = createCredentials(dto.getPwd(), dependent);
            dependent.setCredentials(credentials);

            systemUserRepository.update(dependent);
            handleSuccess(response, "Successfully update dependent", 200, dependent);
        } catch (InvalidInputException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (InvalidCredentialsException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());
        }

        return response;
    }

    public static Response<Dependent> policyHolderUpdateDependent(DependentDTO dto){
        Response<Dependent> response = new Response(null);
        OperationType userAction = new UserAction(new UpdateOperation(), SystemUserType.dependent);
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try{
            PolicyHolder policyHolder = policyHolderRepository.retrieveActorById(dto.getPolicyHolderId());

            if(policyHolder == null){
                throw new InvalidInputException("Policy holder not found", 400);
            }

            Dependent dependent = DependentMapper.toEntity(dto);

            dependent.setPhone(dto.getPhone());
            dependent.setAddress(dto.getAddress());
            dependent.setEmail(dto.getEmail());
            dependent.setFirstName(dto.getFirstName());
            dependent.setLastName(dto.getLastName());

            Credentials credentials = createCredentials(dto.getPwd(), dependent);
            dependent.setCredentials(credentials);

            systemUserRepository.update(dependent);
            handleSuccess(response, "Successfully update dependent", 200, dependent);
        } catch (InvalidInputException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (InvalidCredentialsException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());
        }

        return response;
    }
}
