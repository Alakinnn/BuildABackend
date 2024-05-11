package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;

import java.util.List;


// TODO: MOVE THIS CODE BLOCK CONTENT TO A SERVICE CLASS
public class PolicyOwnerController extends Controller{
    public double calculateAnnualCost(InsuranceCostDTO dto){
        final double dependentCost = 0.6;

        PolicyOwnerRepository repository = new PolicyOwnerRepository();
        PolicyOwner po = repository.retrieveActorById(dto.getId());

        double yearlyRate = po.getYearlyRate();

        int holderCount = 0, dependentCount = 0;

        List<Beneficiary> beneficiaries = repository.retrieveAllBeneficiary(dto.getId());
        for(Customer customer: beneficiaries){
            String customerType = customer.getUserType();
            if(customerType.equals("holder")){holderCount ++;}
            if(customerType.equals("dependent")){dependentCount ++;}
        }

        return holderCount * yearlyRate + dependentCount * yearlyRate * dependentCost;
    }
}
