package com.group07.buildabackend.backend.service.policyOwnerService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;

import java.util.List;

public class PolicyOwnerQueryService extends PolicyOwnerService {
    public static Response<List<SystemUser>> retrieveAll() {
        Response<List<SystemUser>> response = new Response<>(null);

        try {
            PolicyOwnerRepository repo = new PolicyOwnerRepository();
            List<SystemUser> data = repo.retrieveAll();
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<Beneficiary>> retrieveAllBeneficiaries(String userId) {
        Response<List<Beneficiary>> response = new Response<>(null);

        try {
            PolicyOwnerRepository repo = new PolicyOwnerRepository();
            List<Beneficiary> data = repo.retrieveAllBeneficiary(userId);
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<Beneficiary> retrieveBeneficiary(String beneficiaryId, String policyOwnerId) {
        Response<Beneficiary> response = new Response<>(null);

        try {
            PolicyOwnerRepository repo = new PolicyOwnerRepository();
            Beneficiary data = repo.retrieveOneBeneficiary(beneficiaryId, policyOwnerId);
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;

    }
}
