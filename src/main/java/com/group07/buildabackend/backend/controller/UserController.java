package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.ClaimQueryDTO;
import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.dto.user.UpdateUserDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.service.user.QueryClaimService;
import com.group07.buildabackend.backend.service.user.UpdateUserService;
import com.group07.buildabackend.backend.service.user.UserActionService;
import com.group07.buildabackend.backend.service.user.QueryUserService;

import java.util.List;

public class UserController {
    public Response<List<SystemUser>> fetchUsersByName(UserQueryDTO dto){
        return QueryUserService.queryUsersByName(dto);
    }

    public Response<List<SystemUser>> fetchUsersByEmail(UserQueryDTO dto){
        return QueryUserService.queryUsersByEmail(dto);
    }

    public Response<List<SystemUser>> fetchUsersByUserType(UserQueryDTO dto){
        return QueryUserService.queryUsersByUserType(dto);
    }

    public Response<List<UserAction>> fetchUserActionsByActorId(UserQueryDTO dto){
        return UserActionService.fetchUserActionsByActorId(dto);
    }

    public Response<List<SystemUser>> retrieveAll() {
        return QueryUserService.retrieveAll();
    }

    public Response<SystemUser> updateUser(UpdateUserDTO dto) {
        return UpdateUserService.updateUser(dto);
    }

    public Response<SystemUser> retrieveById(String userId) {
        return QueryUserService.retrieveById(userId);
    }

}
