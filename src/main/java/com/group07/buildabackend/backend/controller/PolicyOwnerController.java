package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.policyOwnerService.*;

public class PolicyOwnerController extends Controller{
    public Response<Double> calculateAnnualCost(InsuranceCostDTO insuranceCostDTO){
        return CalculateService.calculateAnnualCost(insuranceCostDTO);
    }

    public Response<InsuranceClaim> updatePolicyHolderClaim(InsuranceClaimDTO insuranceClaimDTO){
        return UpdatePolicyHolderClaimService.updatePolicyHolderClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> updateDependentClaim(InsuranceClaimDTO insuranceClaimDTO){
        return UpdateDependentClaimService.updateDependentClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> deleteSelfClaim(String claimId) {
        return DeleteSelfClaimService.deleteSelfClaim(claimId);
    }

    public Response<InsuranceClaim> deleteBeneficiaryClaim(String claimId, String beneficiaryId) {
        return DeleteBeneficiaryClaimService.deleteBeneficiaryClaim(claimId, beneficiaryId);
    }
}
