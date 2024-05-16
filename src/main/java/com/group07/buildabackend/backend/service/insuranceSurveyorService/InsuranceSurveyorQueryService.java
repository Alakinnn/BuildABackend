package com.group07.buildabackend.backend.service.insuranceSurveyorService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.backend.repository.InsuranceSurveyorRepository;
import com.group07.buildabackend.backend.repository.SystemUserRepository;

import java.util.List;

public class InsuranceSurveyorQueryService extends InsuranceSurveyorService {
    public static Response<List<SystemUser>> retrieveAll(){
        InsuranceSurveyorRepository repo = new InsuranceSurveyorRepository();

        Response<List<SystemUser>> response = new Response<>(null);
        try{
            List<SystemUser> data = repo.retrieveAll();
            handleSuccess(response, "Query Success", 200, data);
        } catch(Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }
}
