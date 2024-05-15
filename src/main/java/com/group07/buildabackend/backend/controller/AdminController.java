package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;

public class AdminController extends SystemController {
    public Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        return createDependentService.createUser(dependentDTO);
    }

    public Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        return createPolicyHolderService.createUser(policyHolderDTO);
    }

    public Response<InsuranceManager> createInsuranceManager(InsuranceManagerDTO insuranceManagerDTO) {
        return createInsuranceManagerService.createUser(insuranceManagerDTO);
    }

    public Response<InsuranceSurveyor> createInsuranceSurveyor(InsuranceSurveyorDTO insuranceSurveyorDTO) {
        return createInsuranceSurveyorService.createUser(insuranceSurveyorDTO);
    }

}