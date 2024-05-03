package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyHolderService.AddClaimInfoService;
import com.group07.buildabackend.backend.service.policyHolderService.CreateClaimService;

import java.io.File;
import java.util.List;

public class PolicyHolderController {

    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        Response<InsuranceClaim> serviceResponse = CreateClaimService.createClaim(insuranceClaimDTO);
        return serviceResponse;
    }

    public Response<InsuranceClaim> addClaimInfo(String claimId, List<File> documents) {
        Response<InsuranceClaim> serviceResponse = AddClaimInfoService.addClaimInfoService(claimId, documents);
        return serviceResponse;
    }

}
