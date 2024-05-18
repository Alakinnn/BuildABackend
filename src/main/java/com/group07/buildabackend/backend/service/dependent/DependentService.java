package com.group07.buildabackend.backend.service.dependent;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.DependentRepository;
import com.group07.buildabackend.backend.service.Service;

import java.util.List;

public class DependentService extends Service {
    public static Response<List<InsuranceClaim>> retrieveAllClaimsById(String userId) {
        Response<List<InsuranceClaim>> response = new Response<>(null);

        try {
            DependentRepository repo = new DependentRepository();
            List<InsuranceClaim> data = repo.retrieveAllClaimsByActorId(userId);
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }
}
