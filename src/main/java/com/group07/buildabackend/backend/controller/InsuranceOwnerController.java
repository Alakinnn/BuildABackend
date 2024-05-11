package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyHolderService.CreateClaimService;
import com.group07.buildabackend.backend.service.policyOwnerService.CreateDependentService;
import com.group07.buildabackend.backend.service.policyOwnerService.CreatePolicyHolderService;
import com.group07.buildabackend.backend.service.userActionService.LogActionService;

public class InsuranceOwnerController extends Controller{
    public Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        Response<PolicyHolder> response = CreatePolicyHolderService.createNewPolicyHolder(policyHolderDTO);

        LogActionService.logUserAction(response.getData().getUserId(), response.getAction(), response.getStatusCode());

        return response;
    }

    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        Response<InsuranceClaim> response = CreateClaimService.createClaim(insuranceClaimDTO);

        LogActionService.logUserAction(response.getData().getCustomer().getUserId(), response.getAction(), response.getStatusCode());

        return response;
    }

    public Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        Response<Dependent> response = CreateDependentService.createNewDependent(dependentDTO);

        LogActionService.logUserAction(response.getData().getPolicyOwner().getUserId(), response.getAction(), response.getStatusCode());

        return response;
    }

}
