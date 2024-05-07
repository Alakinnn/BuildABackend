package com.group07.buildabackend.backend.authentication;

import com.group07.buildabackend.backend.model.SysUser;

public class CurrentUserManager {
    protected static SysUser currentUser;

    public SysUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(SysUser currentUser) {
        this.currentUser = currentUser;
    }
}
