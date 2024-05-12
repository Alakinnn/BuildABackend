package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;

import java.util.List;

public class CalculateService {
    public static double calculateAnnualCost(InsuranceCostDTO dto){
        final double dependentCost = 0.6;

        PolicyOwnerRepository repository = new PolicyOwnerRepository();
        PolicyOwner po = repository.retrieveActorById(dto.getId());

        double yearlyRate = po.getYearlyRate();

        int holderCount = 0, dependentCount = 0;

        List<Beneficiary> beneficiaries = repository.retrieveAllBeneficiary(dto.getId());
        for(Customer customer: beneficiaries){
            SystemUserType customerType = customer.getUserType();
            if(customerType == SystemUserType.policy_holder){holderCount ++;}
            if(customerType == SystemUserType.dependent){dependentCount ++;}
        }

        return holderCount * yearlyRate + dependentCount * yearlyRate * dependentCost;
    }
}
