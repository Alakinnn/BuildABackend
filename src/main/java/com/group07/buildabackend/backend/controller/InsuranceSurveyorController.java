package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.ProposeClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.RequestClaimInfoDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.insuranceManagerService.ApproveClaimService;
import com.group07.buildabackend.backend.service.insuranceSurveyorService.ProposeClaimService;
import com.group07.buildabackend.backend.service.insuranceSurveyorService.RequestClaimInfoService;
import com.group07.buildabackend.backend.service.userActionService.LogActionService;

public class InsuranceSurveyorController extends Controller{
    public Response<InsuranceClaim> proposeClaim(ProposeClaimDTO proposeClaimDTO) {
        Response<InsuranceClaim> response = ApproveClaimService.approveClaim(proposeClaimDTO.getClaimId());

        LogActionService.logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());

        return response;
    }

    public Response<InsuranceClaim> requestClaimInfo(RequestClaimInfoDTO requestClaimInfoDTO) {
        Response<InsuranceClaim> response = ApproveClaimService.approveClaim(requestClaimInfoDTO.getClaimId());

        LogActionService.logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode());

        return response;
    }

}
