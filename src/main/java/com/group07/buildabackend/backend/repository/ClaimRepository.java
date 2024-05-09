package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import jakarta.persistence.Query;

import java.util.List;

public class ClaimRepository extends Repository<InsuranceClaim>{
    public ClaimRepository() {
    }

    @Override
    public void delete(InsuranceClaim item) {

    }

    @Override
    public InsuranceClaim retrieveActorById(String id) {
            Query query = entityManager.createQuery("FROM InsuranceClaim ic WHERE ic.id=:id");
            query.setParameter("id", id);
            return (InsuranceClaim) query.getSingleResult();
    }
}
