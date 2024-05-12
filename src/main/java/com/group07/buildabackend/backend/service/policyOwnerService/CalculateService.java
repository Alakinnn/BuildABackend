package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.userAction.actions.AnnualCostAction;
import com.group07.buildabackend.backend.model.userAction.actions.UserAction;
import com.group07.buildabackend.backend.model.userAction.operations.CreateOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.service.Service;
import com.group07.buildabackend.backend.service.SystemUserService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.util.List;

public class CalculateService extends SystemUserService {
    public static Response<Double> calculateAnnualCost(InsuranceCostDTO dto){
        final double dependentCost = 0.6;
        Response<Double> response = new Response(null);
        OperationType userAction = new AnnualCostAction(new CreateOperation());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try{
            PolicyOwner po = policyOwnerRepository.retrieveActorById(dto.getId());

            if(po == null){
                throw new InvalidInputException("Policy owner not found", 400);
            }

            List<Beneficiary> beneficiaries = policyOwnerRepository.retrieveAllBeneficiary(dto.getId());
            double annualCost = getAnnualCost(beneficiaries, po, dependentCost);

            handleSuccess(response, "Successfully calculated annual cost", 200, annualCost);
        } catch(InvalidInputException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        }
        return response;
    }

    private static double getAnnualCost(List<Beneficiary> beneficiaries, PolicyOwner po, double dependentCost) throws InvalidInputException {
        if(beneficiaries == null){
            throw new InvalidInputException("Beneficiaries not found", 400);
        }

        double yearlyRate = po.getYearlyRate();
        int holderCount = 0, dependentCount = 0;

        for(Customer customer: beneficiaries){
            SystemUserType customerType = customer.getUserType();
            if (customerType == SystemUserType.policy_holder) {holderCount ++;}
            if (customerType == SystemUserType.dependent) {dependentCount ++;}
        }

        return holderCount * yearlyRate + dependentCount * yearlyRate * dependentCost;
    }
}
