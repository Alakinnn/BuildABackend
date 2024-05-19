package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.InsuranceCardQueryDTO;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceCardControllerTest {

    @Test
    void queryInsuranceCardByActorId() {
        InsuranceCardQueryDTO dto = new InsuranceCardQueryDTO();
        dto.setSystemUserId("");

        InsuranceCardController insuranceCardController = new InsuranceCardController();
        Response<InsuranceCard> response = insuranceCardController.queryInsuranceCardByActorId(dto);
        assertNotNull(response);
        assertEquals("", response.getData().getBeneficiary().getUserId());
    }
}