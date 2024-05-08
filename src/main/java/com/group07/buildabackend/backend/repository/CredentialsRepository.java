package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.repository.Repository;

import java.util.List;

public class CredentialsRepository extends Repository<Credentials> {
    @Override
    public void delete(Credentials item) {

    }

    @Override
    public Credentials retrieveActorById(String id) {
        return null;
    }

    @Override
    public List<Credentials> retrieveClaimsByUserId(String id) {
        return null;
    }
}
