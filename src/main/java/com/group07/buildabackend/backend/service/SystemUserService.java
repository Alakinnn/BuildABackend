package com.group07.buildabackend.backend.service;

import com.group07.buildabackend.backend.authentication.PasswordHashing;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUser;

public abstract class SystemUserService extends Service {
    public static Credentials createCredentials(String password, SystemUser systemUser) {
        String salt = PasswordHashing.generateSalt();
        String hashedPwd = PasswordHashing.hashPassword(password, salt);

        Credentials credentials = new Credentials();
        credentials.setSalt(salt);
        credentials.setHashedPwd(hashedPwd);
        credentials.setUser(systemUser);
        return credentials;
    }
}
