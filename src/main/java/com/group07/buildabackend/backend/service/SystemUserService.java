package com.group07.buildabackend.backend.service;

import com.group07.buildabackend.backend.authentication.PasswordHashing;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;

public abstract class SystemUserService extends Service {
    public static Credentials createCredentials(String password, SystemUser systemUser) throws InvalidCredentialsException {
        if(password == null){
            throw new InvalidCredentialsException("Password is required!", 400);
        }

        String salt = PasswordHashing.generateSalt();
        String hashedPwd = PasswordHashing.hashPassword(password, salt);

        Credentials credentials = new Credentials();
        credentials.setSalt(salt);
        credentials.setHashedPwd(hashedPwd);
        credentials.setUser(systemUser);
        return credentials;
    }
}
