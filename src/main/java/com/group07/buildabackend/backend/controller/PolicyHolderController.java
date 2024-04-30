package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.PolicyHolderService;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolicyHolderController {
    private final PolicyHolderService policyHolderService = new PolicyHolderService();

    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        Map<InsuranceClaim, String> serviceResponse = policyHolderService.createClaim(insuranceClaimDTO);

        return getInsuranceClaimResponse(serviceResponse);
    }

    public Response<InsuranceClaim> addClaimInfo(String claimId, List<File> documents) {
        Map<InsuranceClaim, String> serviceResponse = policyHolderService.addClaimInfo(claimId, documents);

        return getInsuranceClaimResponse(serviceResponse);
    }

    private Response<InsuranceClaim> getInsuranceClaimResponse(Map<InsuranceClaim, String> serviceResponse) {
        Map.Entry<InsuranceClaim, String> entry = serviceResponse.entrySet().iterator().next();
        InsuranceClaim insuranceClaim = entry.getKey();
        String message = entry.getValue();

        Response<InsuranceClaim> res = new Response<>(insuranceClaim);
        res.setResponseMsg(message);


        return res;
    }
}
