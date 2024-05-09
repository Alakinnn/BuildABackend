package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.query.user.FilterName;
import com.group07.buildabackend.backend.query.user.UserQuery;
import com.group07.buildabackend.backend.repository.SystemUserRepository;

import java.util.List;

public class UserController {
    public Response<List<SystemUser>> queryUsers(UserQueryDTO dto){
        UserQuery userQuery = new UserQuery();
        SystemUserRepository sysUserRepository = new SystemUserRepository();

        if(dto.getNameVal() != null){
            userQuery = new FilterName(userQuery, dto.getNameVal());
        }

        Response<List<SystemUser>> response = new Response(null);
        try{
            List<SystemUser> data = sysUserRepository.excecuteQuery(userQuery.toString());
            response.setData(data);
        } catch(Exception e){
            response.setResponseMsg(e.getMessage());
        }

        return response;
    }
}
