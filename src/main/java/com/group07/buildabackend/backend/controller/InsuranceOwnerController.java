package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.service.policyOwnerService.CreatePolicyHolderService;

public class InsuranceOwnerController extends Controller{
    public Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        return CreatePolicyHolderService.createNewPolicyHolder(policyHolderDTO);
    }



}
