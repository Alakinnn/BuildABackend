package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import jakarta.persistence.Query;

import java.util.List;

public class ClaimRepository<T extends InsuranceClaim> extends Repository<T>{
    public ClaimRepository() {
    }

    @Override
    public void delete(T item) {

    }

    @Override
    public T retrieveActorById(String id) {
            Query query = entityManager.createQuery("FROM InsuranceClaim ic WHERE ic.id=:id");
            query.setParameter("id", id);
            return (T) query.getSingleResult();
    }

    @Override
    public List<T> retrieveClaimsByUserId(String id) {
        return null;
    }
}
