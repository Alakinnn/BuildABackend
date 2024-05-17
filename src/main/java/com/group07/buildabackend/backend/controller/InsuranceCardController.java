package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.InsuranceCardQueryDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.query.insuranceCard.InsuranceCardQuery;
import com.group07.buildabackend.backend.query.insuranceCard.RetrieveOneCardByActorId;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.service.Service;
import com.group07.buildabackend.backend.service.card.InsuranceCardService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.util.List;

public class InsuranceCardController extends Controller {
    public Response<InsuranceCard> queryInsuranceCardByActorId(InsuranceCardQueryDTO dto){
        return InsuranceCardService.queryInsuranceCardByActorId(dto);
    }
}
