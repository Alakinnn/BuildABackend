package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.service.policyOwnerService.CalculateService;

// TODO: MOVE THIS CODE BLOCK CONTENT TO A SERVICE CLASS
public class PolicyOwnerController extends Controller{
    public double calculateAnnualCost(InsuranceCostDTO insuranceCostDTO){
        return CalculateService.calculateAnnualCost(insuranceCostDTO);
    }
}
