package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.dto.user.UpdateUserDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.service.user.UpdateUserService;
import com.group07.buildabackend.backend.service.user.UserActionService;
import com.group07.buildabackend.backend.service.user.UserQueryService;

import java.util.List;

public class UserController {
    public Response<List<SystemUser>> fetchUsersByName(UserQueryDTO dto){
        return UserQueryService.queryUsersByName(dto);
    }

    public Response<List<SystemUser>> fetchUsersByEmail(UserQueryDTO dto){
        return UserQueryService.queryUsersByEmail(dto);
    }

    public Response<List<SystemUser>> fetchUsersByUserType(UserQueryDTO dto){
        return UserQueryService.queryUsersByUserType(dto);
    }

    public Response<List<SystemUser>> retrieveAll() {
        return UserQueryService.retrieveAll();
    }

    public Response<SystemUser> updateUser(UpdateUserDTO dto) {
        return UpdateUserService.updateUser(dto);
    }

    public Response<List<UserAction>> fetchUserActionsByActorId(UserQueryDTO dto){
        return UserActionService.fetchUserActionsByActorId(dto);
    }
}
