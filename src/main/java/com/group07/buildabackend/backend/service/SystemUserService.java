package com.group07.buildabackend.backend.service;

import com.group07.buildabackend.backend.authentication.PasswordHashing;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.repository.CredentialsRepository;
import com.group07.buildabackend.backend.service.Service;

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
