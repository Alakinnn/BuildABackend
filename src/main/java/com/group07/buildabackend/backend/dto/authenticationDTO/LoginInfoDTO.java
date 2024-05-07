package com.group07.buildabackend.backend.dto.authenticationDTO;

public class LoginInfoDTO {
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
