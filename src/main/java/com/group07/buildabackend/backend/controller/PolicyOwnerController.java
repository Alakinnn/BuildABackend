package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.service.policyOwnerService.CalculateService;
import com.group07.buildabackend.backend.service.policyOwnerService.UpdateDependentService;
import com.group07.buildabackend.backend.service.policyOwnerService.UpdatePolicyHolderService;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyOwnerService.CalculateService;
import com.group07.buildabackend.backend.service.policyOwnerService.DeleteBeneficiaryClaimService;
import com.group07.buildabackend.backend.service.policyOwnerService.DeleteSelfClaimService;

public class PolicyOwnerController extends Controller{
    public Response<Double> calculateAnnualCost(InsuranceCostDTO insuranceCostDTO){
        return CalculateService.calculateAnnualCost(insuranceCostDTO);
    }

    public Response<PolicyHolder> updatePolicyHolder(PolicyHolderDTO policyHolderDTO){
        return UpdatePolicyHolderService.updatePolicyHolder(policyHolderDTO);
    }

    public Response<Dependent> updateDependent(DependentDTO dependentDTO){
        return UpdateDependentService.policyOwnerUpdateDependent(dependentDTO);
        
    public Response<InsuranceClaim> deleteSelfClaim(String claimId) {
        return DeleteSelfClaimService.deleteSelfClaim(claimId);
    }

    public Response<InsuranceClaim> deleteBeneficiaryClaim(String claimId, String beneficiaryId) {
        return DeleteBeneficiaryClaimService.deleteBeneficiaryClaim(claimId, beneficiaryId);
    }
}
