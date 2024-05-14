package com.group07.buildabackend.backend.service;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.repository.*;
import com.group07.buildabackend.backend.service.userActionService.LogActionService;

public abstract class Service {
    protected static final SystemUserRepository systemUserRepository = new SystemUserRepository();
    protected static final PolicyOwnerRepository policyOwnerRepository = new PolicyOwnerRepository();
    protected static final CredentialsRepository credentialsRepository = new CredentialsRepository();
    protected static final PolicyHolderRepository policyHolderRepository = new PolicyHolderRepository();
    protected static final ClaimRepository insuranceClaimRepository = new ClaimRepository();
    protected static final InsuranceSurveyorRepository insuranceSurveyorRepository = new InsuranceSurveyorRepository();
    protected static final UserActionRepository userActionRepository = new UserActionRepository();
    protected static final DependentRepository dependentRepository = new DependentRepository();
    protected static final InsuranceManagerRepository insuranceManagerRepository = new InsuranceManagerRepository();

    public static <T> void handleException(Response<T> response, String message, int statusCode) {
        response.setResponseMsg(message);
        response.setStatusCode(statusCode);
        response.setData(null);
    }

    protected static <T> void handleSuccess(Response<T> response, String message, int statusCode, T data) {
        response.setResponseMsg(message);
        response.setStatusCode(statusCode);
        response.setData(data);
    }

    protected static void logUserAction(String customerId, String action, int statusCode, Response response) {
        LogActionService.logUserAction(customerId, action, statusCode, response);
    }
}
