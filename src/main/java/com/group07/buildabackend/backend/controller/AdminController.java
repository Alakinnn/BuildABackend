package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.PolicyOwnerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.service.systemAdminService.CalculateService;

public class AdminController extends SystemController {
    public Response<Double> calculateSuccessfulClaimsAmount(){
        return CalculateService.calculateSuccessfulClaimsAmount();
    }

    public Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        return createDependentService.create(dependentDTO);
    }

    public Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        return createPolicyHolderService.create(policyHolderDTO);
    }

    public Response<InsuranceManager> createInsuranceManager(InsuranceManagerDTO insuranceManagerDTO) {
        return createInsuranceManagerService.create(insuranceManagerDTO);
    }

    public Response<InsuranceSurveyor> createInsuranceSurveyor(InsuranceSurveyorDTO insuranceSurveyorDTO) {
        return createInsuranceSurveyorService.create(insuranceSurveyorDTO);
    }

    public Response<PolicyOwner> createPolicyOwner(PolicyOwnerDTO policyOwnerDTO) {
        return createPolicyOwnerService.create(policyOwnerDTO);
    }

    public Response<SystemUser> deleteUser(String id) {
        return deleteUserService.deleteUser(id);
    }
}
