package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import jakarta.persistence.Query;

import java.util.List;

public class ClaimRepository extends Repository<InsuranceClaim>{
    public ClaimRepository() {
    }

    @Override
    public void delete(InsuranceClaim item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public InsuranceClaim retrieveActorById(String id) {
            Query query = entityManager.createQuery("FROM InsuranceClaim ic WHERE ic.id=:id");
            query.setParameter("id", id);
            return (InsuranceClaim) query.getSingleResult();
    }
}
