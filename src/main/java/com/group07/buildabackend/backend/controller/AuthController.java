package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.service.LoginService;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.model.SystemUser;

public class AuthController {
    public Response<SystemUser> login(LoginInfoDTO loginInfoDTO) { return LoginService.login(loginInfoDTO); }
}
