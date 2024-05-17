package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.service.LoginService;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.PolicyOwnerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    @Test
    //    ENTER DIFFERENT PHONE, EMAIL VALUES TO TEST
    void createInsuranceManager() {
        // Create test data
        InsuranceManagerDTO managerDTO = new InsuranceManagerDTO();
        managerDTO.setPhone("0915624912");
        managerDTO.setAddress("123 Main St");
        managerDTO.setFirstName("Test");
        managerDTO.setLastName("Admin");
        managerDTO.setEmail("test.admin@example.com");
        managerDTO.setPwd("password123");

        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        loginInfoDTO.setPwd("admin");
        loginInfoDTO.setEmail("admin@rmit.edu.vn");

        LoginService.login(loginInfoDTO);

        AdminController testAdminController = new AdminController();
        Response<InsuranceManager> response = testAdminController.createInsuranceManager(managerDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser createdUser = response.getData();
        assertNotNull(createdUser);
    }

    @Test
    //    ENTER DIFFERENT PHONE, EMAIL VALUES TO TEST
    void createInsuranceSurveyor() {
        // Create test data
        InsuranceSurveyorDTO surveyorDTO = new InsuranceSurveyorDTO();
        surveyorDTO.setPhone("987-654-3210");
        surveyorDTO.setAddress("456 Oak St");
        surveyorDTO.setFirstName("Jane");
        surveyorDTO.setLastName("Smith");
        surveyorDTO.setEmail("jane.smith@example.com");
        surveyorDTO.setPwd("password456");

        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        loginInfoDTO.setPwd("admin");
        loginInfoDTO.setEmail("admin@rmit.edu.vn");

        LoginService.login(loginInfoDTO);

        AdminController testAdminController = new AdminController();
        Response<InsuranceSurveyor> response = testAdminController.createInsuranceSurveyor(surveyorDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser createdUser = response.getData();
        assertNotNull(createdUser);
    }

    @Test
        //    ENTER DIFFERENT PHONE, EMAIL VALUES TO TEST
    void createPolicyHolder() {
        // Create test data
        PolicyHolderDTO policyHolderDTO = new PolicyHolderDTO();
        policyHolderDTO.setPhone("0915231561");
        policyHolderDTO.setAddress("69 Elm St");
        policyHolderDTO.setFirstName("Muhammad");
        policyHolderDTO.setLastName("Alleyway");
        policyHolderDTO.setEmail("Muhammad.Alleyway@example.com");
        policyHolderDTO.setPwd("password456");
        policyHolderDTO.setPolicyOwnerId("u_7b85436d");

        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        loginInfoDTO.setPwd("admin");
        loginInfoDTO.setEmail("admin@rmit.edu.vn");

        LoginService.login(loginInfoDTO);

        AdminController testAdminController = new AdminController();
        Response<PolicyHolder> response = testAdminController.createNewPolicyHolder(policyHolderDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser createdUser = response.getData();
        assertNotNull(createdUser);
    }

    @Test
        //    ENTER DIFFERENT PHONE, EMAIL VALUES TO TEST
    void createPolicyOwner() {
        // Create test data
        PolicyOwnerDTO policyOwner = new PolicyOwnerDTO();
        policyOwner.setPhone("0963135747");
        policyOwner.setAddress("15 Aze St");
        policyOwner.setFirstName("Rahim");
        policyOwner.setLastName("Kzech");
        policyOwner.setEmail("rahim.kzech@example.com");
        policyOwner.setPwd("owner12345");

        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        loginInfoDTO.setPwd("admin");
        loginInfoDTO.setEmail("admin@rmit.edu.vn");

        LoginService.login(loginInfoDTO);

        AdminController testAdminController = new AdminController();
        Response<PolicyOwner> response = testAdminController.createPolicyOwner(policyOwner);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser createdUser = response.getData();
        assertNotNull(createdUser);
    }

    @Test
        //    ENTER DIFFERENT PHONE, EMAIL VALUES TO TEST
    void deleteUser() {
        // Create test data
        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        loginInfoDTO.setPwd("admin");
        loginInfoDTO.setEmail("admin@rmit.edu.vn");
        AdminController testAdminController = new AdminController();

//        PolicyHolderDTO policyHolderDTO = new PolicyHolderDTO();
//        policyHolderDTO.setPhone("0915521561");
//        policyHolderDTO.setAddress("69 Elm St");
//        policyHolderDTO.setFirstName("Elley");
//        policyHolderDTO.setLastName("Melly");
//        policyHolderDTO.setEmail("elly.melly@example.com");
//        policyHolderDTO.setPwd("password456");
//        policyHolderDTO.setPolicyOwnerId("u_7b85436d");
//
        LoginService.login(loginInfoDTO);
//
//        Response<PolicyHolder> response = testAdminController.createNewPolicyHolder(policyHolderDTO);

        Response<SystemUser> response = testAdminController.deleteUser("u_2414db00");

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser createdUser = response.getData();
        assertNotNull(createdUser);
    }
}