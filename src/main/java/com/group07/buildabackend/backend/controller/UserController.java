package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.query.user.FilterName;
import com.group07.buildabackend.backend.query.user.SortName;
import com.group07.buildabackend.backend.query.user.SortNameDesc;
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
        if(dto.isAsc()){
            userQuery = new SortName(userQuery);
        }
        if(dto.isDesc()){
            userQuery = new SortNameDesc(userQuery);
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

    public static void main(String[] args) {
//        UserController controller = new UserController();
//        UserQueryDTO dto = new UserQueryDTO();
//        dto.setAsc(true);
//
//        Response<List<SysUser>> response = controller.queryUsers(dto);
//        List<SysUser> data = response.getData();
//        System.out.println(data);
//        data.forEach(System.out::println);
//        controller.queryUsers(dto).getData().forEach(System.out::println);

        UserQuery userQuery = new UserQuery();
        userQuery = new SortName(userQuery);
        SystemUserRepository repository = new SystemUserRepository();
        System.out.println(userQuery);
        List<SystemUser> sysUsers = repository.excecuteQuery(userQuery.toString());
        System.out.println(sysUsers);
    }
}
