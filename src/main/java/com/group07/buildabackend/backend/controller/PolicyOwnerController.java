package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyHolderService.CreateClaimService;
import com.group07.buildabackend.backend.service.policyHolderService.UpdateDependentClaimService;
import com.group07.buildabackend.backend.service.policyOwnerService.CalculateService;
import com.group07.buildabackend.backend.service.policyOwnerService.DeleteBeneficiaryClaimService;
import com.group07.buildabackend.backend.service.policyOwnerService.DeleteSelfClaimService;
import com.group07.buildabackend.backend.service.policyOwnerService.UpdatePolicyHolderClaimService;

public class PolicyOwnerController extends SystemController {
    public Response<Double> calculateAnnualCost(InsuranceCostDTO insuranceCostDTO) {
        return CalculateService.calculateAnnualCost(insuranceCostDTO);
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
        return createPolicyHolderService.createUser(policyHolderDTO);
    }

    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return CreateClaimService.createClaim(insuranceClaimDTO);
    }

    public Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        return createDependentService.createUser(dependentDTO);
    }
}
