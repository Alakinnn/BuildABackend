package com.group07.buildabackend.backend.dto.authenticationDTO;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.DTO;

public class LoginInfoDTO implements DTO {
    private String email;
    private String pwd;

    public LoginInfoDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
