package com.group07.buildabackend.backend.service;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.repository.*;

public abstract class Service {
    public static final SystemUserRepository systemUserRepository = new SystemUserRepository();
    public static final PolicyOwnerRepository policyOwnerRepository = new PolicyOwnerRepository();
    public static final CredentialsRepository credentialsRepository = new CredentialsRepository();
    public static final PolicyHolderRepository policyHolderRepository = new PolicyHolderRepository();
    public static final ClaimRepository insuranceClaimRepository = new ClaimRepository();
    public static final InsuranceSurveyorRepository insuranceSurveyorRepository = new InsuranceSurveyorRepository();
    public static final UserActionRepository userActionRepository = new UserActionRepository();
    public static <T> void handleException(Response<T> response, String message, int statusCode) {
        response.setResponseMsg(message);
        response.setStatusCode(statusCode);
        response.setData(null);
    }

    public static <T> void handleSuccess(Response<T> response, String message, int statusCode, T data) {
        response.setResponseMsg(message);
        response.setStatusCode(statusCode);
        response.setData(data);
    }
}
