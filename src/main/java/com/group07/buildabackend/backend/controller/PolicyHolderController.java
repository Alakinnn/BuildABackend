package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.AddClaimInfoDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyHolderService.AddClaimInfoService;
import com.group07.buildabackend.backend.service.policyHolderService.CreateClaimService;
import com.group07.buildabackend.backend.service.policyOwnerService.CreateDependentService;
import com.group07.buildabackend.backend.service.policyOwnerService.CreatePolicyHolderService;
import com.group07.buildabackend.backend.service.userActionService.LogActionService;

public class PolicyHolderController extends Controller{
    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return CreateClaimService.createClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> addClaimInfo(AddClaimInfoDTO addClaimInfoDTO) {
        Response<InsuranceClaim> response = AddClaimInfoService.addClaimInfoService(addClaimInfoDTO);

        LogActionService.logUserAction(response.getData().getCustomer().getUserId(), response.getAction(), response.getStatusCode());
        return response;
    }

    public Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        Response<Dependent> response = CreateDependentService.createNewDependent(dependentDTO);

        LogActionService.logUserAction(response.getData().getPolicyHolder().getUserId(), response.getAction(), response.getStatusCode());

        return response;
    }

}
