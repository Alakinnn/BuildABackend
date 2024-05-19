package com.group07.buildabackend.backend.repository;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.Credentials;
import jakarta.persistence.Query;

public class CredentialsRepository extends Repository<Credentials> {
    @Override
    public Credentials retrieveActorById(String userId) {
        Query query = entityManager.createQuery("FROM Credentials c WHERE c.userId=:userId");
        query.setParameter("userId", userId);
        return (Credentials) query.getSingleResult();
    }

}
