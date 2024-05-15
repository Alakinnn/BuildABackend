package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.dto.user.UpdateUserDTO;
import com.group07.buildabackend.backend.dto.userActionDTO.UserActionDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.query.user.FilterName;
import com.group07.buildabackend.backend.query.user.UserQuery;
import com.group07.buildabackend.backend.query.userAction.RetrieveUserActionsByActorId;
import com.group07.buildabackend.backend.query.userAction.UserActionQuery;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.service.user.UpdateUserService;

import java.util.List;

public class UserController {
    public Response<List<SystemUser>> queryUsers(UserQueryDTO dto){
        UserQuery userQuery = new UserQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getNameVal() != null){
            userQuery = new FilterName(userQuery, dto.getNameVal());
        }

        Response<List<SystemUser>> response = new Response(null);
        try{
            List<SystemUser> data = systemUserRepository.executeQueryUsers(userQuery.toString());
            response.setData(data);
        } catch(Exception e){
            response.setResponseMsg(e.getMessage());
        }

        return response;
    }

    public Response<SystemUser> updateUser(UpdateUserDTO dto) {
        return UpdateUserService.updateUser(dto);
    }

    public Response<List<UserAction>> fetchUserActionsByActorId(UserActionDTO dto){
        UserActionQuery userActionQuery = new UserActionQuery();
        SystemUserRepository systemUserRepository = new SystemUserRepository();

        if(dto.getSystemUserId() != null){
            userActionQuery = new RetrieveUserActionsByActorId(userActionQuery, dto.getSystemUserId());
        }

        Response<List<UserAction>> response = new Response(null);

        try{
            List<UserAction> data = systemUserRepository.fetchUserActionsByUserId(userActionQuery.toString());
            response.setData(data);
        } catch(Exception e){
            response.setResponseMsg(e.getMessage());
        }

        return response;
    }
}
