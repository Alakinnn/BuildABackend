package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.PolicyHolderService;

import java.io.File;
import java.util.List;

public class PolicyHolderController {
    private final PolicyHolderService policyHolderService = new PolicyHolderService();

//    public InsuranceClaim createClaim(String customerId, String receiverBankName, String receiverBankNumber, String receiverName, double claimAmount, String examDate, List<File> documents) {
//        InsuranceClaim insuranceClaim = policyHolderService.createClaim(customerId, receiverBankName, receiverBankNumber, receiverName, claimAmount, examDate, documents);
//        return insuranceClaim;
//    }

        public Response<InsuranceClaim> createClaim(String customerId, String receiverBankName, String receiverBankNumber, String receiverName, double claimAmount, String examDate, List<File> documents) {
        InsuranceClaim insuranceClaim = policyHolderService.createClaim(customerId, receiverBankName, receiverBankNumber, receiverName, claimAmount, examDate, documents);
        Response<InsuranceClaim> res = new Response<>(insuranceClaim);
        res.setOk(false);
        res.setErrorMsg("User not found");
        return res;
    }

    public InsuranceClaim addClaimInfo(String claimId, List<File> documents) {
        InsuranceClaim insuranceClaim = policyHolderService.addClaimInfo(claimId, documents);
        return insuranceClaim;
    }
}
