package com.group07.buildabackend.backend.service.policyHolderService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;

import java.util.List;

import static com.group07.buildabackend.backend.utils.fileUtils.FileListMapper.mapToDocumentList;

public class PolicyHolderQueryService extends PolicyHolderService {
    public static Response<List<SystemUser>> retrieveAll() {
        Response<List<SystemUser>> response = new Response<>(null);

        try {
            PolicyHolderRepository repo = new PolicyHolderRepository();
            List<SystemUser> data = repo.retrieveAll();
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<Dependent>> retrieveAllDependents(String userId) {
        Response<List<Dependent>> response = new Response<>(null);

        try {
            PolicyHolderRepository repo = new PolicyHolderRepository();
            List<Dependent> data = repo.retrieveAllDependent(userId);
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<InsuranceClaim>> retrieveAllClaimsById(String userId) {
        Response<List<InsuranceClaim>> response = new Response<>(null);

        try {
            PolicyHolderRepository repo = new PolicyHolderRepository();
            List<InsuranceClaim> data = repo.retrieveAllClaimsByActorId(userId);
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<InsuranceClaim>> retrieveAllDependentClaims(String userId) {
        Response<List<InsuranceClaim>> response = new Response<>(null);

        try {
            PolicyHolderRepository repo = new PolicyHolderRepository();
            List<InsuranceClaim> data = repo.retrieveAllDependentClaim(userId);
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }
}
