package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;
import jakarta.persistence.NoResultException;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.group07.buildabackend.backend.service.policyHolderService.PolicyHolderService.holderRepository;
import static org.junit.jupiter.api.Assertions.*;

class CreateClaimServiceTest {
    @BeforeEach
    void setUp() {
        // Prepare PolicyHolder entity
        PolicyHolder policyHolder = new PolicyHolder();
        policyHolder.setUserId("1");
        policyHolder.setPhone("0123456789");
        policyHolder.setAddress("Hanoi");
        policyHolder.setEmail("policyholder@com");
        policyHolder.setPassword("123456");
        policyHolder.setFirstName("John");
        policyHolder.setLastName("Doe");

        policyHolder.setCustomerType("PolicyHolder");

        PolicyHolderRepository<PolicyHolder> holderRepository = new PolicyHolderRepository<>();
        holderRepository.add(policyHolder);
    }

    @Test
    void testCreateClaim_customerNotFound() {
        CreateClaimService createClaimService = new CreateClaimService();
        InsuranceClaimDTO insuranceClaimDTO = createValidInsuranceClaimDTO();
        Response<InsuranceClaim> response = createClaimService.createClaim(insuranceClaimDTO);

//        assertThrows(NoResultException.class, ()->{holderRepository.retrieveById(insuranceClaimDTO.getCustomerId());});
        assertNull(response.getData());
        assertEquals(400, response.getStatusCode());
        assertEquals("Customer not found", response.getResponseMsg());
    }

    @Test
    void createClaimCustomerNotFound(){
//        when(insuranceClaimDTO.getCustomerId()).thenReturn("999");
//        Response<InsuranceClaim> response = createClaimService.createClaim(insuranceClaimDTO);
//        assertEquals(400, response.getStatusCode());
//        assertEquals("Customer not found", response.getResponseMsg());
    }

    private InsuranceClaimDTO createValidInsuranceClaimDTO() {
        InsuranceClaimDTO validClaimDTO = new InsuranceClaimDTO();
        validClaimDTO.setAmount(1000);
        validClaimDTO.setClaimDate("05/07/2024");
        validClaimDTO.setReceiverBankName("VIB");
        validClaimDTO.setReceiverBankNumber("123456");
        validClaimDTO.setReceiverName("John");

        return validClaimDTO;
    }

    private InsuranceClaimDTO createInvalidInsuranceDTO() {
        InsuranceClaimDTO invalidClaimDTO = new InsuranceClaimDTO();
        invalidClaimDTO.setAmount(0);
        invalidClaimDTO.setExamDate("05/02/2024");
        invalidClaimDTO.setReceiverBankName("TP");
        invalidClaimDTO.setReceiverName("Hoang");
        invalidClaimDTO.setReceiverBankNumber("012345");

        return invalidClaimDTO;
    }


}