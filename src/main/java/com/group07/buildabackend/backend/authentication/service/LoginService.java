package com.group07.buildabackend.backend.authentication.service;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.authentication.PasswordVerification;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.model.SysUser;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;

public class LoginService extends Authentication {
    public static Response<SysUser> login(LoginInfoDTO loginInfoDTO) {
        Response<SysUser> response = new Response<>(null);
        try {
            String email = loginInfoDTO.getEmail();
            String pwd = loginInfoDTO.getPwd();

            SysUser sysUser = sysUserRepository.retrieveActorByEmail(email);

            if (sysUser == null) {
                throw new InvalidCredentialsException("Email not found", 400);
            }

            boolean isCorrectPwd;
            String hashedPwd = sysUserRepository.retrieveHashedPwdById(sysUser.getUserId());
            String salt = sysUserRepository.retrieveSaltById(sysUser.getUserId());
            isCorrectPwd = PasswordVerification.verifyPassword(pwd, hashedPwd, salt);

            if (!isCorrectPwd) {
                throw new InvalidCredentialsException("Invalid password", 400);
            }

            response.setData(sysUser);
            response.setResponseMsg("Successfully logged in!");
            response.setStatusCode(200);

            CurrentUserManager.setCurrentUser(sysUser);

        } catch (InvalidCredentialsException e) {
            response.setData(null);
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(e.getErrorCode());
        }
        return response;
    }
}
