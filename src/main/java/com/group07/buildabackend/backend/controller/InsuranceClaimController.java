package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimMapper;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.UpdateClaimDTO;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.UpdateOperation;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.service.claim.QueryClaimService;
import com.group07.buildabackend.backend.service.claim.UpdateClaimService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.time.LocalDate;
import java.util.List;


public class InsuranceClaimController {

    public Response<List<InsuranceClaim>> retrieveAll() {
        return QueryClaimService.retrieveAll();
    }

    public Response<InsuranceClaim> updateClaim(UpdateClaimDTO dto) {
        return UpdateClaimService.updateClaim(dto);
    }
}
