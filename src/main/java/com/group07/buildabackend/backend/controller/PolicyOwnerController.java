package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.service.policyOwnerService.CalculateService;

public class PolicyOwnerController extends Controller{
    public Response<Double> calculateAnnualCost(InsuranceCostDTO insuranceCostDTO){
        return CalculateService.calculateAnnualCost(insuranceCostDTO);
    }
}
