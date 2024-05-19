package com.group07.buildabackend.backend.controller;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.queryDTO.InsuranceCardQueryDTO;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.service.card.InsuranceCardService;

public class InsuranceCardController extends Controller {
    public Response<InsuranceCard> queryInsuranceCardByActorId(InsuranceCardQueryDTO dto){
        return InsuranceCardService.queryInsuranceCardByActorId(dto);
    }
}
