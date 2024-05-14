package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.model.provider.InsuranceManager;

public interface InsuranceSurveyorFactory {
    InsuranceManager retrieveInsuranceManager(String insuranceManagerId);
}
