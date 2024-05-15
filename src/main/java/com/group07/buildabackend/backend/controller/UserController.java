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
import com.group07.buildabackend.backend.service.user.UserActionService;
import com.group07.buildabackend.backend.service.user.UserQueryService;

import java.util.List;

public class UserController {
    public Response<List<SystemUser>> queryUsers(UserQueryDTO dto){
        return UserQueryService.queryUsers(dto);
    }

    public Response<List<SystemUser>> retrieveAll() {
        return UserQueryService.retrieveAll();
    }

    public Response<SystemUser> updateUser(UpdateUserDTO dto) {
        return UpdateUserService.updateUser(dto);
    }

    public Response<List<UserAction>> fetchUserActionsByActorId(UserActionDTO dto){
        return UserActionService.fetchUserActionsByActorId(dto);
    }
}
