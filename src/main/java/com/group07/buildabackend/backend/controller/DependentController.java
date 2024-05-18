package com.group07.buildabackend.backend.controller;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.service.dependent.DependentService;

import java.util.List;

public class DependentController extends Controller {
    public Response<List<InsuranceClaim>> retrieveAllClaimsById(String userId) {
        return DependentService.retrieveAllClaimsById(userId);
    }
}
