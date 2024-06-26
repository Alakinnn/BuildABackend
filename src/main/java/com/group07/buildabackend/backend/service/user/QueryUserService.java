package com.group07.buildabackend.backend.service.user;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.query.user.FilterEmail;
import com.group07.buildabackend.backend.query.user.FilterName;
import com.group07.buildabackend.backend.query.user.FilterUserType;
import com.group07.buildabackend.backend.query.user.UserQuery;
import com.group07.buildabackend.backend.repository.SystemUserRepository;

import java.util.List;

public class QueryUserService extends SystemUserService {
    public static Response<SystemUser> retrieveById(String userId) {
        Response<SystemUser> response = new Response<>(null);
        SystemUserRepository<SystemUser> repo = new SystemUserRepository<>();


        try{
            SystemUser data = repo.retrieveActorById(userId);
            handleSuccess(response, "Query Success", 200, data);
        } catch(Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }
    public static Response<List<SystemUser>> queryUsersByName(UserQueryDTO dto){
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

    public static Response<List<SystemUser>> queryUsersByEmail(UserQueryDTO dto){
        UserQuery userQuery = new UserQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getEmail() != null){
            userQuery = new FilterEmail(userQuery, dto.getEmail());
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

    public static Response<List<SystemUser>> queryUsersByUserType(UserQueryDTO dto){
        UserQuery userQuery = new UserQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getUserType() != null){
            userQuery = new FilterUserType(userQuery, dto.getUserType());
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
        SystemUserRepository<SystemUser> repo = new SystemUserRepository<>();

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
