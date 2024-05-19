package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.service.LoginService;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
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
        policyHolderDTO.setEmail("muhammad.alleyway@example.com");
        policyHolderDTO.setPwd("password456");
        policyHolderDTO.setPolicyOwnerId("u_d91f227e");

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
        //    ENTER ID TO TEST
    void deleteUser() {
        // Create test data
        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        loginInfoDTO.setPwd("admin");
        loginInfoDTO.setEmail("admin@rmit.edu.vn");
        AdminController testAdminController = new AdminController();

        LoginService.login(loginInfoDTO);

        Response<SystemUser> response = testAdminController.deleteUser("u_7b85436d");

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser createdUser = response.getData();
        assertNotNull(createdUser);
    }

    @Test
    void createNewDependent() {
        // Create test data
        DependentDTO dependentDTO = new DependentDTO();
        dependentDTO.setPhone("123-456-7890");
        dependentDTO.setAddress("789 Pine St");
        dependentDTO.setFirstName("Alice");
        dependentDTO.setLastName("Wonderland");
        dependentDTO.setEmail("alice.wonderland@example.com");
        dependentDTO.setPwd("password789");
        dependentDTO.setPolicyHolderId("u_1c2f699d");

        AdminController testAdminController = new AdminController();
        Response<Dependent> response = testAdminController.createNewDependent(dependentDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        Dependent createdDependent = response.getData();
        assertNotNull(createdDependent);
    }

    // Test for creating a new Policy Owner
    @Test
    void createPolicyOwner() {
        // Create test data
        PolicyOwnerDTO policyOwnerDTO = new PolicyOwnerDTO();
        policyOwnerDTO.setPhone("321-654-9870");
        policyOwnerDTO.setAddress("321 Cedar St");
        policyOwnerDTO.setFirstName("Bob");
        policyOwnerDTO.setLastName("Builder");
        policyOwnerDTO.setEmail("bob.builder@example.com");
        policyOwnerDTO.setPwd("build123");

        AdminController testAdminController = new AdminController();
        Response<PolicyOwner> response = testAdminController.createPolicyOwner(policyOwnerDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        PolicyOwner createdPolicyOwner = response.getData();
        assertNotNull(createdPolicyOwner);
    }

    // Test for calculating successful claims amount
    @Test
    void calculateSuccessfulClaimsAmount() {
        AdminController testAdminController = new AdminController();
        Response<Double> response = testAdminController.calculateSuccessfulClaimsAmount();

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getData() > 0);
    }
}