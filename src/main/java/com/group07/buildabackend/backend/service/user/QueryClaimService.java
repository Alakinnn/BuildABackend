package com.group07.buildabackend.backend.service.user;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.queryDTO.ClaimQueryDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.query.claim.*;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.service.Service;

import java.util.List;

public class QueryClaimService extends Service {
    public static Response<List<InsuranceClaim>> fetchClaimsByStatus(ClaimQueryDTO dto){
        ClaimQuery claimQuery = new ClaimQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getStatus() != null){
            claimQuery = new FilterStatus(claimQuery, dto.getStatus());
        }

        Response<List<InsuranceClaim>> response = new Response<>(null);
        try{
            List<InsuranceClaim> data = systemUserRepository.executeQueryInsuranceClaim(claimQuery.toString());
            handleSuccess(response, "Query Success", 200, data);
        } catch(Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<InsuranceClaim>> fetchClaimsByAmount(ClaimQueryDTO dto){
        ClaimQuery claimQuery = new ClaimQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getAmount() != null){
            claimQuery = new FilterAmount(claimQuery, dto.getAmount());
        }

        Response<List<InsuranceClaim>> response = new Response<>(null);
        try{
            List<InsuranceClaim> data = systemUserRepository.executeQueryInsuranceClaim(claimQuery.toString());
            handleSuccess(response, "Query Success", 200, data);
        } catch(Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<InsuranceClaim>> fetchClaimsByClaimDate(ClaimQueryDTO dto){
        ClaimQuery claimQuery = new ClaimQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getYear() != null){
            claimQuery = new FilterClaimDate(claimQuery, dto.getYear(), dto.getMonth(), dto.getDay());
        }

        Response<List<InsuranceClaim>> response = new Response<>(null);
        try{
            List<InsuranceClaim> data = systemUserRepository.executeQueryInsuranceClaim(claimQuery.toString());
            handleSuccess(response, "Query Success", 200, data);
        } catch(Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<InsuranceClaim>> fetchClaimsByExamDate(ClaimQueryDTO dto){
        ClaimQuery claimQuery = new ClaimQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getYear() != null){
            claimQuery = new FilterExamDate(claimQuery, dto.getYear(), dto.getMonth(), dto.getDay());
        }

        Response<List<InsuranceClaim>> response = new Response<>(null);
        try{
            List<InsuranceClaim> data = systemUserRepository.executeQueryInsuranceClaim(claimQuery.toString());
            handleSuccess(response, "Query Success", 200, data);
        } catch(Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<InsuranceClaim>> retrieveAll() {
        Response<List<InsuranceClaim>> res = new Response<>(null);
        try {
            ClaimRepository repo = new ClaimRepository();
            List<InsuranceClaim> claims = repo.retrieveAll();
            handleSuccess(res, "Query Success", 200, claims);
        } catch (Exception e) {
            handleException(res, e.getMessage(), 400);
        }

        return res;
    }

    public static Response<InsuranceClaim> retrieveById(String claimId) {
        Response<InsuranceClaim> res = new Response<>(null);
        try {
            ClaimRepository repo = new ClaimRepository();
            InsuranceClaim claims = repo.retrieveActorById(claimId);
            handleSuccess(res, "Query Success", 200, claims);
        } catch (Exception e) {
            handleException(res, e.getMessage(), 400);
        }

        return res;
    }
}
