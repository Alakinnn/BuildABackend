package com.group07.buildabackend.backend.service.createUserService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import static com.group07.buildabackend.backend.service.user.UserCredentialsService.createCredentials;

public class CreateInsuranceManagerService extends CreateSystemUserService<InsuranceManagerDTO, InsuranceManager> implements SystemUserProduct<InsuranceManagerDTO, InsuranceManager> {
    @Override
    public Response<InsuranceManager> createUser(InsuranceManagerDTO dto) {
        return execute(dto, SystemUserType.insurance_manager);
    }

    @Override
    public void validateAndCreate(InsuranceManagerDTO dto, Response<InsuranceManager> response) throws InvalidInputException, InvalidCredentialsException {
        InsuranceManager insuranceManager;
        SystemUserValidator.validateInput(dto);

        insuranceManager = InsuranceManagerMapper.toEntity(dto);

        Credentials credentials = createCredentials(dto.getPwd(), insuranceManager);

        setRelations(insuranceManager, credentials);

        systemUserRepository.add(insuranceManager);

        handleSuccess(response, "Successfully created new insurance manager", 200, insuranceManager);
    }

    @Override
    public void setRelations(InsuranceManager user, Object... args) {
        Credentials credentials = (Credentials) args[0];

        user.setCredentials(credentials);
    }
}
