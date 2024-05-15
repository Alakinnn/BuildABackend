package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.PolicyOwnerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.PolicyOwnerMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import static com.group07.buildabackend.backend.service.user.UserCredentialsService.createCredentials;

public class CreatePolicyOwnerService extends CreateSystemUserService<PolicyOwnerDTO, PolicyOwner> implements SystemUserProduct<PolicyOwnerDTO, PolicyOwner> {
    @Override
    public Response<PolicyOwner> createUser(PolicyOwnerDTO dto) {
        return execute(dto, SystemUserType.policy_owner);
    }

    @Override
    public void validateAndCreate(PolicyOwnerDTO dto, Response<PolicyOwner> response) throws InvalidInputException, InvalidCredentialsException {
        PolicyOwner policyOwner;
        SystemUserValidator.validateInput(dto);

        policyOwner = PolicyOwnerMapper.toEntity(dto);

        InsuranceCard insuranceCard = new InsuranceCard();
        Credentials credentials = createCredentials(dto.getPwd(), policyOwner);

        setRelations(policyOwner, insuranceCard, credentials);
        systemUserRepository.add(policyOwner);
        handleSuccess(response, "Successfully created new policy owner", 200, policyOwner);

    }

    @Override
    public void setRelations(PolicyOwner user, Object... args) {
        Credentials credentials = (Credentials) args[0];

        user.setCredentials(credentials);
    }
}
