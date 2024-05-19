package com.group07.buildabackend.backend.repository;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.operations.AllRetrievable;
import jakarta.persistence.Query;

import java.util.List;

public class ClaimRepository extends Repository<InsuranceClaim> implements AllRetrievable<InsuranceClaim> {
    public ClaimRepository() {
    }

    @Override
    public InsuranceClaim retrieveActorById(String id) {
            Query query = entityManager.createQuery("FROM InsuranceClaim ic WHERE ic.id=:id");
            query.setParameter("id", id);
            return (InsuranceClaim) query.getSingleResult();
    }

    @Override
    public List<InsuranceClaim> retrieveAll() {
        Query query = entityManager.createQuery("SELECT c FROM InsuranceClaim c", InsuranceClaim.class);
        return (List<InsuranceClaim>) query.getResultList();
    }
}
