package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.operations.ClaimRetrievable;
import jakarta.persistence.Query;

import java.util.List;

public class DependentRepository extends SystemUserRepository<Dependent> implements ClaimRetrievable<InsuranceClaim> {
    @Override
    public Dependent retrieveActorById(String id) {
        Query query = entityManager.createQuery("FROM Dependent d WHERE d.id=:id");
        query.setParameter("id", id);
        return (Dependent) query.getSingleResult();
    }

    @Override
    public List<InsuranceClaim> retrieveAllClaimsByActorId(String id) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN Dependent d on ic.customer.id = d.id WHERE d.id = :dId");
        query.setParameter("dId", id);

        return query.getResultList();
    }

    @Override
    public InsuranceClaim retrieveOneClaimByActorId(String claimId, String systemUserId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN Dependent d on ic.customer.id = d.id WHERE d.id = :dependentId AND ic.id = :claimId");
        query.setParameter("dependentId", systemUserId);
        query.setParameter("claimId", claimId);

        return (InsuranceClaim) query.getResultList();
    }
}
