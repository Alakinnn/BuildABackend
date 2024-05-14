package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentMapper;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.Dependent;
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

public class CreatePolicyHolderService extends SystemUserService implements SystemUserFactory<PolicyHolderDTO, PolicyHolder>, PolicyHolderFactory {

    public CreatePolicyHolderService() {
    }

    @Override
        public Response<PolicyHolder> createUser(PolicyHolderDTO dto) {
            Response<PolicyHolder> response = new Response<>(null);
            OperationType userAction = new UserAction(new CreateOperation(), SystemUserType.policy_holder);
            String actionDescription = userAction.getDescription();
            response.setAction(actionDescription);
            try {
                validateAndCreate(dto, response);
            } catch (InvalidInputException e) {
                handleException(response, e.getMessage(), 400);
            } catch (InvalidCredentialsException e) {
                handleException(response, e.getMessage(), 400);
            } finally {
                logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
            }
            return response;
        }

        @Override
        public void validateAndCreate(PolicyHolderDTO dto, Response<PolicyHolder> response) throws InvalidInputException, InvalidCredentialsException {
            PolicyHolder policyHolder;
            SystemUserValidator.validateInput(dto);

            policyHolder = PolicyHolderMapper.toEntity(dto);

            PolicyOwner policyOwner = retrievePolicyOwner(dto.getPolicyOwnerId());

            InsuranceCard insuranceCard = new InsuranceCard();
            Credentials credentials = createCredentials(dto.getPwd(), policyHolder);

            setRelations(policyHolder, policyOwner, policyHolder, insuranceCard, credentials);

            systemUserRepository.add(policyHolder);

            handleSuccess(response, "Successfully created new dependent", 200, policyHolder);
        }

        @Override
        public void setRelations(PolicyHolder user, Object... args) {
            PolicyOwner policyOwner = (PolicyOwner) args[0];
            InsuranceCard insuranceCard = (InsuranceCard) args[2];
            Credentials credentials = (Credentials) args[3];

            user.setPolicyOwner(policyOwner);
            user.setInsuranceCard(insuranceCard);
            user.setCredentials(credentials);
        }

        @Override
        public PolicyOwner retrievePolicyOwner(String policyOwnerId) {
            return policyOwnerRepository.retrieveActorById(policyOwnerId);
        }
}

