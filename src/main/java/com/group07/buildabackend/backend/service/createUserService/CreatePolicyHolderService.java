package com.group07.buildabackend.backend.service.createUserService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import static com.group07.buildabackend.backend.service.user.UserCredentialsService.createCredentials;

public class CreatePolicyHolderService extends CreateSystemUserService<PolicyHolderDTO, PolicyHolder> implements SystemUserProduct<PolicyHolderDTO, PolicyHolder>, PolicyHolderRelationRetrievable {

    public CreatePolicyHolderService() {
    }

    @Override
    public Response<PolicyHolder> createUser(PolicyHolderDTO dto) {
        return execute(dto, SystemUserType.policy_holder);
    }

    @Override
    public void validateAndCreate(PolicyHolderDTO dto, Response<PolicyHolder> response) throws InvalidInputException, InvalidCredentialsException {
        PolicyHolder policyHolder;
        SystemUserValidator.validateInput(dto);

        policyHolder = PolicyHolderMapper.toEntity(dto);

        PolicyOwner policyOwner = retrievePolicyOwner(dto.getPolicyOwnerId());

        InsuranceCard insuranceCard = new InsuranceCard();
        Credentials credentials = createCredentials(dto.getPwd(), policyHolder);

        setRelations(policyHolder, policyOwner, insuranceCard, credentials);

        systemUserRepository.add(policyHolder);

        handleSuccess(response, "Successfully created new policy holder", 200, policyHolder);
    }

    @Override
    public void setRelations(PolicyHolder user, Object... args) {
        PolicyOwner policyOwner = (PolicyOwner) args[0];
        InsuranceCard insuranceCard = (InsuranceCard) args[1];
        Credentials credentials = (Credentials) args[2];

        user.setPolicyOwner(policyOwner);
        user.setInsuranceCard(insuranceCard);
        user.setCredentials(credentials);
    }

    @Override
    public PolicyOwner retrievePolicyOwner(String policyOwnerId) {
        return policyOwnerRepository.retrieveActorById(policyOwnerId);
    }
}

