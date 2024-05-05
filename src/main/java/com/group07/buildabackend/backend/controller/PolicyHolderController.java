package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyHolderService.AddClaimInfoService;
import com.group07.buildabackend.backend.service.policyHolderService.CreateClaimService;

import java.io.File;
import java.util.List;

public class PolicyHolderController {

    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return CreateClaimService.createClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> addClaimInfo(String claimId, List<File> documents) {
        return AddClaimInfoService.addClaimInfoService(claimId, documents);
    }

}
