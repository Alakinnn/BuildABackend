package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolicyHolderControllerTest {

    @Test
    //    ENTER DIFFERENT PHONE, EMAIL VALUES TO TEST
    public void testCreateDependentDTO() {
        DependentDTO testDependentDTO = new DependentDTO();
        testDependentDTO.setPolicyHolderId("u_bc7abc35");
        testDependentDTO.setPhone("123-456-7890");
        testDependentDTO.setAddress("123 Main St");
        testDependentDTO.setFirstName("Test");
        testDependentDTO.setLastName("Dependent");
        testDependentDTO.setEmail("alice@example.com");
        testDependentDTO.setPwd("password123");

        PolicyHolderController testPolicyHolderController = new PolicyHolderController();
        Response<Dependent> response = testPolicyHolderController.createNewDependent(testDependentDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser createdUser = response.getData();
        assertNotNull(createdUser);
    }
}