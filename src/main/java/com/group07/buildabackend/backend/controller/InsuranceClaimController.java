package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.UpdateClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.user.QueryClaimService;
import com.group07.buildabackend.backend.service.claim.UpdateClaimService;

import java.util.List;


public class InsuranceClaimController {

    public Response<List<InsuranceClaim>> retrieveAll() {
        return QueryClaimService.retrieveAll();
    }

    public Response<InsuranceClaim> updateClaim(UpdateClaimDTO dto) {
        return UpdateClaimService.updateClaim(dto);
    }
}
