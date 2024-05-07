package com.group07.buildabackend.backend.authentication.service;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.authentication.PasswordVerification;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;

public class LoginService extends Authentication {
    public static Response<SystemUser> login(LoginInfoDTO loginInfoDTO) {
        Response<SystemUser> response = new Response<>(null);
        try {
            String email = loginInfoDTO.getEmail();
            String pwd = loginInfoDTO.getPwd();

            SystemUser systemUser = SYSTEM_USER_REPOSITORY.retrieveActorByEmail(email);

            if (systemUser == null) {
                throw new InvalidCredentialsException("Email not found", 400);
            }

            boolean isCorrectPwd;
            String hashedPwd = SYSTEM_USER_REPOSITORY.retrieveHashedPwdById(systemUser.getUserId());
            String salt = SYSTEM_USER_REPOSITORY.retrieveSaltById(systemUser.getUserId());
            isCorrectPwd = PasswordVerification.verifyPassword(pwd, hashedPwd, salt);

            if (!isCorrectPwd) {
                throw new InvalidCredentialsException("Invalid password", 400);
            }

            handleSuccess(response, "Successfully logged in!", 200, systemUser);
            CurrentUserManager.setCurrentUser(systemUser);

        } catch (InvalidCredentialsException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        }
        return response;
    }
}
