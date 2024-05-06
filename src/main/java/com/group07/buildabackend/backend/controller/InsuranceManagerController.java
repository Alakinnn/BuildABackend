package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.insuranceManagerService.ApproveClaimService;
import com.group07.buildabackend.backend.service.insuranceManagerService.RejectClaimService;

public class InsuranceManagerController {
    public Response<InsuranceClaim> approveClaim(String claimId) {
        return ApproveClaimService.approveClaim(claimId);
    }

    public Response<InsuranceClaim> rejectClaim(String claimId) {
        return RejectClaimService.rejectClaim(claimId);
    }

}
