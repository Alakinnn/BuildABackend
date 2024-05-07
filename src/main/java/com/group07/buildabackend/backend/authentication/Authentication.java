package com.group07.buildabackend.backend.authentication;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.model.SysUser;
import com.group07.buildabackend.backend.repository.SysUserRepository;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;

public class Authentication {
    private static final SysUserRepository sysUserRepository = new SysUserRepository();
    public static Response<SysUser> login(LoginInfoDTO loginInfoDTO) {
        Response<SysUser> response = new Response<>(null);
        try {
            String email = loginInfoDTO.getEmail();
            String pwd = loginInfoDTO.getPwd();

            SysUser sysUser = sysUserRepository.retrieveActorByEmail(email);

            if (sysUser == null) {
                throw new InvalidCredentialsException("Email not found", 400);
            }


        } catch (InvalidCredentialsException e) {
            response.setData(null);
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(e.getErrorCode());
        }
    }
}
