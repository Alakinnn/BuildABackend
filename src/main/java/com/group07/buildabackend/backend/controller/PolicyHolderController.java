package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.AddClaimInfoDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyHolderService.AddClaimInfoService;
import com.group07.buildabackend.backend.service.policyHolderService.CreateClaimService;
import com.group07.buildabackend.backend.service.policyOwnerService.CreateDependentService;

public class PolicyHolderController extends Controller{
    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return CreateClaimService.createClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> addClaimInfo(AddClaimInfoDTO dto) {
        return AddClaimInfoService.addClaimInfoService(dto);
    }

    public Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        return CreateDependentService.createNewDependent(dependentDTO);
    }
}
