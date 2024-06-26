package com.group07.buildabackend.backend.controller;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.UpdateClaimDTO;
import com.group07.buildabackend.backend.dto.queryDTO.ClaimQueryDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.claim.DeleteClaimService;
import com.group07.buildabackend.backend.service.user.QueryClaimService;
import com.group07.buildabackend.backend.service.claim.UpdateClaimService;

import java.util.List;


public class InsuranceClaimController {

    public Response<List<InsuranceClaim>> retrieveAll() {
        return QueryClaimService.retrieveAll();
    }

    public Response<InsuranceClaim> retrieveById(String claimId) {
        return QueryClaimService.retrieveById(claimId);
    }

    public Response<InsuranceClaim> updateClaim(UpdateClaimDTO dto) {
        return UpdateClaimService.updateClaim(dto);
    }

    public Response<InsuranceClaim> deleteClaim(String claimId) {
        return DeleteClaimService.deleteClaim(claimId);
    }


    public Response<List<InsuranceClaim>> fetchClaimsByStatus(ClaimQueryDTO dto){
        return QueryClaimService.fetchClaimsByStatus(dto);
    }

    public Response<List<InsuranceClaim>> fetchClaimsByAmount(ClaimQueryDTO dto){
        return QueryClaimService.fetchClaimsByAmount(dto);
    }

    public Response<List<InsuranceClaim>> fetchClaimsByClaimDate(ClaimQueryDTO dto){
        return QueryClaimService.fetchClaimsByClaimDate(dto);
    }

    public Response<List<InsuranceClaim>> fetchClaimsByExamDate(ClaimQueryDTO dto){
        return QueryClaimService.fetchClaimsByExamDate(dto);
    }
}
