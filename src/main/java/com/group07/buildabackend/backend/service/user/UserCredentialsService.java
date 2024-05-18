package com.group07.buildabackend.backend.service.user;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.PasswordHashing;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.repository.CredentialsRepository;
import com.group07.buildabackend.backend.service.Service;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;

public abstract class UserCredentialsService extends SystemUserService {
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

    public static Response<Credentials> updateCredentials(String newPassword, SystemUser systemUser) {
        Response<Credentials> res = new Response<>(null);

        CredentialsRepository repo = new CredentialsRepository();
        Credentials credentials = repo.retrieveActorById(systemUser.getUserId());

        if (credentials == null) {
            handleException(res, "User not found", 404);
            return res;
        }

        String salt = PasswordHashing.generateSalt();
        String hashedPwd = PasswordHashing.hashPassword(newPassword, salt);

        credentials.setSalt(salt);
        credentials.setHashedPwd(hashedPwd);
        repo.update(credentials);

        handleSuccess(res, "Successfully update credentials", 202, credentials);
        return res;
    }
}
