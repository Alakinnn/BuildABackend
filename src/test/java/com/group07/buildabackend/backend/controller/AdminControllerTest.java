package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.service.LoginService;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    @Test
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
    void createInsuranceSurveyor() {
        // Create test data
        InsuranceSurveyorDTO surveyorDTO = new InsuranceSurveyorDTO();
        surveyorDTO.setPhone("987-654-3210");
        surveyorDTO.setAddress("456 Oak St");
        surveyorDTO.setFirstName("Jane");
        surveyorDTO.setLastName("Smith");
        surveyorDTO.setEmail("jane.smith@example.com");
        surveyorDTO.setPwd("password456");
        surveyorDTO.setInsuranceManagerId("u_893f615a");

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
}