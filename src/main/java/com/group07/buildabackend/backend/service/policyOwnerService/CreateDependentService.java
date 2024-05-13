package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.userAction.actions.UserAction;
import com.group07.buildabackend.backend.model.userAction.operations.CreateOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.service.SystemUserService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import org.hibernate.HibernateException;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class CreateDependentService extends SystemUserService {
    public static Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        Response<Dependent> response = new Response<>(null);

        OperationType userAction = new UserAction(new CreateOperation(), SystemUserType.dependent);
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try {
            SystemUserValidator.validateInput(dependentDTO);

            Dependent dependent = DependentMapper.toEntity(dependentDTO);
            PolicyOwner policyOwner = policyOwnerRepository.retrieveActorById(dependentDTO.getPolicyOwnerId());

            if (policyOwner == null) {
                throw new InvalidInputException("Policy owner not found", 400);
            }

            PolicyHolder policyHolder = policyHolderRepository.retrieveActorById(dependentDTO.getPolicyHolderId());

            if (policyHolder == null) {
                throw new InvalidInputException("Policy holder not found", 400);
            }

            InsuranceCard insuranceCard = new InsuranceCard();

            Credentials credentials = createCredentials(dependentDTO.getPwd(), dependent);

            dependent.setPolicyOwner(policyOwner);
            dependent.setPolicyHolder(policyHolder);
            dependent.setInsuranceCard(insuranceCard);
            dependent.setCredentials(credentials);

            systemUserRepository.add(dependent);

            handleSuccess(response, "Successfully created new policy holder", 200, dependent);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (InvalidCredentialsException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (HibernateException e) {
            handleException(response, e.getMessage(), 409);
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());
        }
        return response;
    }
}
