package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.model.provider.InsuranceManager;

public interface InsuranceSurveyorRelationRetrievable {
    InsuranceManager retrieveInsuranceManager(String insuranceManagerId);
}
