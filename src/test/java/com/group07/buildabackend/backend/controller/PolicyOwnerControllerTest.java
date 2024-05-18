package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolicyOwnerControllerTest {

    @Test
    //    ENTER DIFFERENT PHONE, EMAIL VALUES TO TEST
    void createNewPolicyHolder() {
        PolicyHolderDTO testPolicyHolderDto = new PolicyHolderDTO();
        testPolicyHolderDto.setPolicyOwnerId("u_7b85436d");
        testPolicyHolderDto.setPhone("1355514213");
        testPolicyHolderDto.setAddress("123 Main St");
        testPolicyHolderDto.setFirstName("Test");
        testPolicyHolderDto.setLastName("Holder");
        testPolicyHolderDto.setEmail("Test2@example.com");
        testPolicyHolderDto.setPwd("password123");

        PolicyOwnerController testPolicyOwnerController = new PolicyOwnerController();
        Response<PolicyHolder> response = testPolicyOwnerController.createNewPolicyHolder(testPolicyHolderDto);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser createdUser = response.getData();
        assertNotNull(createdUser);
    }

    @Test
        //    ENTER DIFFERENT BENEFICIARY ID
    void deleteBeneficiary() {
        PolicyOwnerController testPolicyOwnerController = new PolicyOwnerController();
        Response<Beneficiary> response = testPolicyOwnerController.deleteBeneficiary("u_e23fc536");

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        SystemUser deletedUser = response.getData();
        assertNotNull(deletedUser);
    }
}