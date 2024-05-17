package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
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
}
