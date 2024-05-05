package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateClaimServiceTest {

    @Test
    void createClaim() {

    }

//    private InsuranceClaimDTO createValidInsuranceClaimDTO() {
//
//
//        return validClaimDTO;
//    }

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