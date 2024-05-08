package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.SysUser;
import com.group07.buildabackend.backend.query.user.FilterName;
import com.group07.buildabackend.backend.query.user.SortName;
import com.group07.buildabackend.backend.query.user.SortNameDesc;
import com.group07.buildabackend.backend.query.user.UserQuery;
import com.group07.buildabackend.backend.repository.SysUserRepository;

import java.util.List;

public class UserController {
    public Response<List<SysUser>> queryUsers(UserQueryDTO dto){
        UserQuery userQuery = new UserQuery();
        SysUserRepository sysUserRepository = new SysUserRepository();

        if(dto.getNameVal() != null){
            userQuery = new FilterName(userQuery, dto.getNameVal());
        }
        if(dto.isAsc()){
            userQuery = new SortName(userQuery);
        }
        if(dto.isDesc()){
            userQuery = new SortNameDesc(userQuery);
        }

        Response<List<SysUser>> response = new Response(null);
        try{
            List<SysUser> data = sysUserRepository.executeQuery(userQuery.toString());
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
        SysUserRepository repository = new SysUserRepository();
        System.out.println(userQuery);
        List<SysUser> sysUsers = repository.executeQuery(userQuery.toString());
        System.out.println(sysUsers);
    }
}
