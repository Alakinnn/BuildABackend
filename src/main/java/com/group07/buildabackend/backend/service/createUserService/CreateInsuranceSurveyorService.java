package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.service.user.UserCredentialsService;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class CreateInsuranceSurveyorService extends UserCredentialsService implements SystemUserFactory<InsuranceSurveyorDTO, InsuranceSurveyor>, InsuranceSurveyorFactory  {
    @Override
    public Response<InsuranceSurveyor> createUser(InsuranceSurveyorDTO dto) {
        return execute(dto, SystemUserType.insurance_surveyor);
    }

    @Override
    public void validateAndCreate(InsuranceSurveyorDTO dto, Response<InsuranceSurveyor> response) throws    InvalidInputException, InvalidCredentialsException {
        InsuranceSurveyor insuranceSurveyor;
        SystemUserValidator.validateInput(dto);

        insuranceSurveyor = InsuranceSurveyorMapper.toEntity(dto);

        InsuranceManager insuranceManager = retrieveInsuranceManager(dto.getInsuranceManagerId());
        Credentials credentials = createCredentials(dto.getPwd(), insuranceSurveyor);

        setRelations(insuranceSurveyor, insuranceManager, credentials);

        systemUserRepository.add(insuranceSurveyor);

        handleSuccess(response, "Successfully created new insurance manager", 200, insuranceSurveyor);
    }

    @Override
    public void setRelations(InsuranceSurveyor user, Object... args) {
        InsuranceManager insuranceManager = (InsuranceManager) args[0];
        Credentials credentials = (Credentials) args[1];

        user.setInsuranceManager(insuranceManager);
        user.setCredentials(credentials);
    }

    @Override
    public InsuranceManager retrieveInsuranceManager(String insuranceManagerId) {
        return insuranceManagerRepository.retrieveActorById(insuranceManagerId);
    }
}



