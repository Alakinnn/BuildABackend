package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import jakarta.persistence.Query;

public class CredentialsRepository extends Repository<Credentials> {
    @Override
    public void delete(Credentials item) {

    }

    @Override
    public Credentials retrieveActorById(String userId) {
        Query query = entityManager.createQuery("FROM Credentials c WHERE c.userId=:userId");
        query.setParameter("userId", userId);
        return (Credentials) query.getSingleResult();
    }

}
