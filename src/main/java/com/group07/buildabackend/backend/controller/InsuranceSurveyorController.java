package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.ProposeClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.RequestClaimInfoDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.repository.operations.AllRetrievable;
import com.group07.buildabackend.backend.service.insuranceManagerService.ApproveClaimService;
import com.group07.buildabackend.backend.service.insuranceManagerService.RejectClaimService;
import com.group07.buildabackend.backend.service.insuranceSurveyorService.InsuranceSurveyorQueryService;
import com.group07.buildabackend.backend.service.insuranceSurveyorService.ProposeClaimService;
import com.group07.buildabackend.backend.service.insuranceSurveyorService.RequestClaimInfoService;
import com.group07.buildabackend.backend.service.userActionService.LogActionService;

import java.util.List;

public class InsuranceSurveyorController extends Controller {
    public Response<InsuranceClaim> proposeClaim(ProposeClaimDTO proposeClaimDTO) {
        return ProposeClaimService.proposeClaim(proposeClaimDTO);
    }

    public Response<InsuranceClaim> requestClaimInfo(RequestClaimInfoDTO requestClaimInfoDTO) {
        return RequestClaimInfoService.requestClaimInfo(requestClaimInfoDTO);
    }

    public Response<List<SystemUser>> retrieveAll() {
        return InsuranceSurveyorQueryService.retrieveAll();
    }

}
