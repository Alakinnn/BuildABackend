package com.group07.buildabackend.backend.authentication;

import com.group07.buildabackend.backend.model.SystemUser;

public class CurrentUserManager {
    protected static SystemUser currentUser;

    public static SystemUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(SystemUser currentUser) {
        CurrentUserManager.currentUser = currentUser;
    }
}
