package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.AddClaimInfoDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;
import com.group07.buildabackend.backend.service.policyHolderService.AddClaimInfoService;
import com.group07.buildabackend.backend.service.policyHolderService.CreateClaimService;

import java.util.List;


public class PolicyHolderController extends Controller{
    public Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        return CreateClaimService.createClaim(insuranceClaimDTO);
    }

    public Response<InsuranceClaim> addClaimInfo(AddClaimInfoDTO dto) {
        return AddClaimInfoService.addClaimInfoService(dto);
    }

    public void calculateAnnualInsuranceCost(){

    }

    public static void main(String[] args) {
        double annualInsuranceCost = 0.0;
        final double dependentCost = 0.6;

        PolicyOwnerRepository repository = new PolicyOwnerRepository();
        PolicyOwner po = repository.retrieveActorById("u1");
        double yearlyRate = po.getYearlyRate(); //500.0

        int holderCount = 0, dependentCount = 0;

        List<Beneficiary> beneficiary = repository.retrieveAllBeneficiary("u1");
        for(Customer customer: beneficiary){
            String customerType = customer.getCustomerType();
            if(customerType.equals("holder")){holderCount += 1;}
            if(customerType.equals("dependent")){dependentCount += 1;}
        }

        annualInsuranceCost = (double)holderCount * yearlyRate + (double)dependentCount * yearlyRate * dependentCost;
        System.out.println("Annual insurance cost" + annualInsuranceCost);
    }
}
