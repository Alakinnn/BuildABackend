package com.group07.buildabackend.backend.service.user;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.query.userAction.RetrieveUserActionsByActorId;
import com.group07.buildabackend.backend.query.userAction.UserActionQuery;
import com.group07.buildabackend.backend.repository.SystemUserRepository;

import java.util.List;

public class UserActionService extends SystemUserService{
    public static Response<List<UserAction>> fetchUserActionsByActorId(UserQueryDTO dto){
        UserActionQuery userActionQuery = new UserActionQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getSystemUserId() != null){
            userActionQuery = new RetrieveUserActionsByActorId(userActionQuery, dto.getSystemUserId());
        }

        Response<List<UserAction>> response = new Response(null);

        try{
            List<UserAction> data = systemUserRepository.fetchUserActionsByUserId(userActionQuery.toString());
            handleSuccess(response, "Query Success", 200, data);
        } catch(Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }
}
