package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.service.createUserService.CreateDependentService;
import com.group07.buildabackend.backend.service.createUserService.CreateInsuranceManagerService;
import com.group07.buildabackend.backend.service.createUserService.CreateInsuranceSurveyorService;
import com.group07.buildabackend.backend.service.createUserService.CreatePolicyHolderService;

public abstract class SystemController extends Controller {
    protected static CreateDependentService createDependentService = new CreateDependentService();
    protected static CreatePolicyHolderService createPolicyHolderService = new CreatePolicyHolderService();
    protected static CreateInsuranceManagerService createInsuranceManagerService = new CreateInsuranceManagerService();
    protected static CreateInsuranceSurveyorService createInsuranceSurveyorService = new CreateInsuranceSurveyorService();
}
