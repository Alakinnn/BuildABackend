package com.group07.buildabackend.backend.controller;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.PolicyOwnerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.service.systemAdminService.DeleteUserService;
import com.group07.buildabackend.backend.service.createUserService.*;

public abstract class SystemController extends Controller {
    protected static CreateSystemUserService<DependentDTO, Dependent> createDependentService = new CreateDependentService();
    protected static CreateSystemUserService<PolicyHolderDTO, PolicyHolder> createPolicyHolderService = new CreatePolicyHolderService();
    protected static CreateSystemUserService<InsuranceManagerDTO, InsuranceManager> createInsuranceManagerService = new CreateInsuranceManagerService();
    protected static CreateSystemUserService<InsuranceSurveyorDTO, InsuranceSurveyor> createInsuranceSurveyorService = new CreateInsuranceSurveyorService();
    protected static CreateSystemUserService<PolicyOwnerDTO, PolicyOwner> createPolicyOwnerService = new CreatePolicyOwnerService();
    protected static DeleteUserService deleteUserService = new DeleteUserService();
}
