package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyHolderService.CreateClaimService;
import com.group07.buildabackend.backend.service.policyHolderService.UpdateDependentClaimService;
import com.group07.buildabackend.backend.service.policyOwnerService.*;

import java.util.List;

public class PolicyOwnerController extends SystemController {
    public Response<List<SystemUser>> retrieveAll() {
        return PolicyOwnerQueryService.retrieveAll();
    }

    public Response<List<Beneficiary>> retrieveAllBeneficiaries(String userId) {
        return PolicyOwnerQueryService.retrieveAllBeneficiaries(userId);
    }

    public Response<Beneficiary> retrieveBeneficiary(String beneficiaryId, String policyOwnerId) {
        return PolicyOwnerQueryService.retrieveBeneficiary(beneficiaryId, policyOwnerId);
    }

    public Response<Double> calculateAnnualCost(InsuranceCostDTO insuranceCostDTO) {
        return CalculateService.calculateAnnualCost(insuranceCostDTO);
    }

    public Response<Double> getYearlyRate(InsuranceCostDTO insuranceCostDTO) {
        return CalculateService.getYearlyRate(insuranceCostDTO);
    }

    public Response<InsuranceClaim> updatePolicyHolderClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return UpdatePolicyHolderClaimService.updatePolicyHolderClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> updateDependentClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return UpdateDependentClaimService.updateDependentClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> deleteSelfClaim(String claimId) {
        return DeleteSelfClaimService.deleteSelfClaim(claimId);
    }

    public Response<InsuranceClaim> deleteBeneficiaryClaim(String claimId, String beneficiaryId) {
        return DeleteBeneficiaryClaimService.deleteBeneficiaryClaim(claimId, beneficiaryId);
    }

    public Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        return createPolicyHolderService.create(policyHolderDTO);
    }

    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return CreateClaimService.createClaim(insuranceClaimDTO);
    }

    public Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        return createDependentService.create(dependentDTO);
    }

    public Response<Beneficiary> deleteBeneficiary(String beneficiaryId) {
        return DeleteBeneficiaryService.deleteBeneficiary(beneficiaryId);
    }
}
