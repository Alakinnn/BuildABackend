package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.insuranceManagerService.ApproveClaimService;
import com.group07.buildabackend.backend.service.insuranceManagerService.RejectClaimService;
import com.group07.buildabackend.backend.service.userActionService.LogActionService;

public class InsuranceManagerController extends Controller{
    public Response<InsuranceClaim> approveClaim(String claimId) {
        Response<InsuranceClaim> response = ApproveClaimService.approveClaim(claimId);

        LogActionService.logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());

        return response;
    }

    public Response<InsuranceClaim> rejectClaim(String claimId) {
        Response<InsuranceClaim> response = RejectClaimService.rejectClaim(claimId);

        LogActionService.logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());

        return response;
    }
}
