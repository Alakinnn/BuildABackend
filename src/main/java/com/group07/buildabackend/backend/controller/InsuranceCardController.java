package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.InsuranceCardQueryDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.query.insuranceCard.InsuranceCardQuery;
import com.group07.buildabackend.backend.query.insuranceCard.RetrieveOneCardByActorId;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.service.Service;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.util.List;

public class InsuranceCardController extends Service {
    public Response<InsuranceCard> queryInsuranceCardByActorId(InsuranceCardQueryDTO dto){
        InsuranceCardQuery insuranceCardQuery = new InsuranceCardQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getSystemUserId() != null){
            insuranceCardQuery = new RetrieveOneCardByActorId(insuranceCardQuery, dto.getSystemUserId());
        }

        Response<InsuranceCard> response = new Response<>(null);

        try{
            InsuranceCard insuranceCard = systemUserRepository.executeQueryInsuranceCard(insuranceCardQuery.toString());
            if(insuranceCard == null){
                throw new InvalidInputException("Insurance card not found", 404);
            }
            response.setData(insuranceCard);
        } catch (InvalidInputException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (Exception e){
            response.setResponseMsg(e.getMessage());
        }

        return response;
    }
}
