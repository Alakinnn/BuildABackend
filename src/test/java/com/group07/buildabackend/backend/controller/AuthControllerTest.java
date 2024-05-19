package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.authentication.service.LoginService;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class AuthControllerTest {
        @Test
        public void testLogin() {
            LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
            loginInfoDTO.setPwd("admin");
            loginInfoDTO.setEmail("admin@rmit.edu.vn");

            LoginService.login(loginInfoDTO);
            String id = CurrentUserManager.getCurrentUser().getUserId();

            assertNotNull(id);
        }

}