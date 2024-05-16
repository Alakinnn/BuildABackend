package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import static com.group07.buildabackend.backend.service.user.UserCredentialsService.createCredentials;

public class CreateInsuranceSurveyorService extends CreateSystemUserService<InsuranceSurveyorDTO, InsuranceSurveyor> implements SystemUserProduct<InsuranceSurveyorDTO, InsuranceSurveyor> {
    @Override
    public Response<com.group07.buildabackend.backend.model.provider.InsuranceSurveyor> createUser(InsuranceSurveyorDTO dto) {
        return execute(dto, SystemUserType.insurance_surveyor);
    }

    @Override
    public void validateAndCreate(InsuranceSurveyorDTO dto, Response<InsuranceSurveyor> response) throws InvalidInputException, InvalidCredentialsException {
        InsuranceSurveyor insuranceSurveyor;
        SystemUserValidator.validateInput(dto);

        insuranceSurveyor = InsuranceSurveyorMapper.toEntity(dto);

        Credentials credentials = createCredentials(dto.getPwd(), insuranceSurveyor);

        setRelations(insuranceSurveyor, credentials);

        systemUserRepository.add(insuranceSurveyor);

        handleSuccess(response, "Successfully created new insurance manager", 200, insuranceSurveyor);
    }

    @Override
    public void setRelations(com.group07.buildabackend.backend.model.provider.InsuranceSurveyor user, Object... args) {
        Credentials credentials = (Credentials) args[0];

        user.setCredentials(credentials);
    }
}



