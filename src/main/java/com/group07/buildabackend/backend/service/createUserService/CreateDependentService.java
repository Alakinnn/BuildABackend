package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.service.SystemUserService;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class CreateDependentService extends SystemUserService implements SystemUserFactory<DependentDTO, Dependent>, DependentFactory {
    @Override
    public Response<Dependent> createUser(DependentDTO dto) {
        return execute(dto, SystemUserType.dependent);
    }

    @Override
    public void validateAndCreate(DependentDTO dto, Response<Dependent> response) throws InvalidInputException, InvalidCredentialsException {
        Dependent dependent;
        SystemUserValidator.validateInput(dto);

        dependent = DependentMapper.toEntity(dto);

        PolicyHolder policyHolder = retrievePolicyHolder(dto.getPolicyHolderId());
        PolicyOwner policyOwner = retrievePolicyOwner(policyHolder.getPolicyOwner().getUserId());

        InsuranceCard insuranceCard = new InsuranceCard();
        Credentials credentials = createCredentials(dto.getPwd(), dependent);

        setRelations(dependent, policyOwner, policyHolder, insuranceCard, credentials);

        systemUserRepository.add(dependent);

        handleSuccess(response, "Successfully created new dependent", 200, dependent);
    }

    @Override
    public void setRelations(Dependent user, Object... args) {
        PolicyOwner policyOwner = (PolicyOwner) args[0];
        PolicyHolder policyHolder = (PolicyHolder) args[1];
        InsuranceCard insuranceCard = (InsuranceCard) args[2];
        Credentials credentials = (Credentials) args[3];

        user.setPolicyOwner(policyOwner);
        user.setPolicyHolder(policyHolder);
        user.setInsuranceCard(insuranceCard);
        user.setCredentials(credentials);
    }

    @Override
    public PolicyHolder retrievePolicyHolder(String policyHolderId) {
        return policyHolderRepository.retrieveActorById(policyHolderId);
    }

    @Override
    public PolicyOwner retrievePolicyOwner(String policyOwnerId) {
        return policyOwnerRepository.retrieveActorById(policyOwnerId);
    }
}
