package com.group07.buildabackend.backend.service.user;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.query.user.FilterName;
import com.group07.buildabackend.backend.query.user.UserQuery;
import com.group07.buildabackend.backend.repository.SystemUserRepository;

import java.util.List;

public class UserQueryService extends SystemUserService {
    public static Response<List<SystemUser>> queryUsers(UserQueryDTO dto){
        UserQuery userQuery = new UserQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getNameVal() != null){
            userQuery = new FilterName(userQuery, dto.getNameVal());
        }

        Response<List<SystemUser>> response = new Response<>(null);
        try{
            List<SystemUser> data = systemUserRepository.executeQueryUsers(userQuery.toString());
            handleSuccess(response, "Query Success", 200, data);
        } catch(Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }

    public static Response<List<SystemUser>> retrieveAll(){
        SystemUserRepository repo = new SystemUserRepository();

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
