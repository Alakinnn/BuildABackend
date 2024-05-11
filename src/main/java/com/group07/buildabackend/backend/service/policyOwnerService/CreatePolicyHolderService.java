package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.model.userAction.actions.UserAction;
import com.group07.buildabackend.backend.model.userAction.operations.CreateOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.service.SystemUserService;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;
import org.hibernate.HibernateException;

public class CreatePolicyHolderService extends SystemUserService {
    public static Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        Response<PolicyHolder> response = new Response<>(null);
        OperationType userAction = new UserAction(new CreateOperation(), PolicyHolder.getUserType());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try {
            SystemUserValidator.validateInput(policyHolderDTO);

            PolicyHolder policyHolder = PolicyHolderMapper.toEntity(policyHolderDTO);
            PolicyOwner policyOwner = policyOwnerRepository.retrieveActorById(policyHolderDTO.getPolicyOwnerId());

            if (policyOwner == null) {
                throw new InvalidInputException("Policy owner not found", 400);
            }

            InsuranceCard insuranceCard = new InsuranceCard();
            Credentials credentials = createCredentials(policyHolderDTO.getPwd(), policyHolder);

            if (credentials == null) {
                throw new InvalidCredentialsException("Password is required!", 400);
            }

            policyHolder.setPolicyOwner(policyOwner);
            policyHolder.setInsuranceCard(insuranceCard);
            policyHolder.setCredentials(credentials);

            systemUserRepository.add(policyHolder);


            handleSuccess(response, "Successfully created new policy holder", 200, policyHolder);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (HibernateException e) {
            handleException(response, e.getMessage(), 409);
        } catch (InvalidCredentialsException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());
        }
        return response;
    }


}
