package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.insuranceSuveyorService.ProposeClaimService;
import com.group07.buildabackend.backend.service.insuranceSuveyorService.RequestClaimInfoService;

public class InsuranceSurveyorController {
    public Response<InsuranceClaim> proposeClaim(String claimId) {
        return ProposeClaimService.proposeClaim(claimId);
    }

    public Response<InsuranceClaim> requestClaimInfo(String claimId, String note) {
        return RequestClaimInfoService.requestClaimInfo(claimId, note);
    }
}
