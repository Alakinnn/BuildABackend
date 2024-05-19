package com.group07.buildabackend.backend.controller;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.AddClaimInfoDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyHolderService.*;

import java.util.List;

public class PolicyHolderController extends SystemController {

    public Response<List<SystemUser>> retrieveAll() {
        return PolicyHolderQueryService.retrieveAll();
    }

    public Response<List<Dependent>> retrieveAllDependents(String userId) {
        return PolicyHolderQueryService.retrieveAllDependents(userId);
    }

    public Response<List<InsuranceClaim>> retrieveAllClaimsById(String userId) {
        return PolicyHolderQueryService.retrieveAllClaimsById(userId);
    }

    public Response<List<InsuranceClaim>> retrieveAllDependentClaims(String userId) {
        return PolicyHolderQueryService.retrieveAllDependentClaims(userId);
    }

    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return CreateClaimService.createClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> addClaimInfo(AddClaimInfoDTO addClaimInfoDTO) {
        return AddClaimInfoService.addClaimInfoService(addClaimInfoDTO);
    }

    public Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        return createDependentService.create(dependentDTO);
    }

    public Response<InsuranceClaim> updateSelfClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return UpdateSelfClaimService.updateSelfClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> updateDependentClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return UpdateDependentClaimService.updateDependentClaim(insuranceClaimDTO);
    }
}
