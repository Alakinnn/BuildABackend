package com.group07.buildabackend.backend.authentication;

import com.group07.buildabackend.backend.model.SysUser;

public class CurrentUserManager {
    protected static SysUser currentUser;

    public static SysUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(SysUser currentUser) {
        CurrentUserManager.currentUser = currentUser;
    }
}
