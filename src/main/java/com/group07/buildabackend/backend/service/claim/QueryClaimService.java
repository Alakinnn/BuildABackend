package com.group07.buildabackend.backend.service.claim;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.service.Service;

import java.util.List;

public class QueryClaimService extends Service {
    public static Response<List<InsuranceClaim>> retrieveAll() {
        Response<List<InsuranceClaim>> res = new Response<>(null);
        try {
            ClaimRepository repo = new ClaimRepository();
            List<InsuranceClaim> claims = repo.retrieveAll();
            handleSuccess(res, "Query Success", 200, claims);
        } catch (Exception e) {
            handleException(res, e.getMessage(), 400);
        }

        return res;
    }
}
