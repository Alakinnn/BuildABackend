package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.operations.ClaimRetrievable;
import com.group07.buildabackend.backend.repository.operations.DependentRetrievable;

import jakarta.persistence.Query;

import java.util.List;

public class PolicyHolderRepository extends Repository<PolicyHolder> implements ClaimRetrievable<InsuranceClaim>, DependentRetrievable<Dependent> {
    public PolicyHolderRepository() {
    }

    @Override
    public PolicyHolder retrieveActorById(String id) {
            Query query = entityManager.createQuery("FROM Beneficiary be WHERE be.id=:id");
            query.setParameter("id", id);
            return (PolicyHolder) query.getSingleResult();
    }

    @Override
    public List<InsuranceClaim> retrieveAllClaimsByActorId(String id) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN PolicyHolder ph on ic.customer.id = ph.id WHERE ph.id = :phId");
        query.setParameter("phId", id);

        return query.getResultList();
    }

    @Override
    public InsuranceClaim retrieveOneClaimByActorId(String claimId, String systemUserId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN PolicyHolder ph on ic.customer.id = ph.id WHERE ph.id = :phId AND ic.id = :claimId");
        query.setParameter("phId", systemUserId);
        query.setParameter("claimId", claimId);

        return (InsuranceClaim) query.getSingleResult();
    }

    @Override
    public List<InsuranceClaim> retrieveAllDependentClaim(String holderId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN Dependent d on ic.customer.id = d.id WHERE d.policyHolder.id = :holderId");
        query.setParameter("holderId", holderId);

        return query.getResultList();
    }

    @Override
    public InsuranceClaim retrieveOneDependentClaim(String claimId, String holderId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN Dependent d on ic.customer.id = d.id WHERE d.policyHolder.id = :holderId AND ic.id = :claimId");
        query.setParameter("holderId", holderId);
        query.setParameter("claimId", claimId);

        return (InsuranceClaim) query.getSingleResult();
    }

    @Override
    public List<Dependent> retrieveAllDependent(String holderId) {
        Query query = entityManager.createQuery("SELECT d " +
                "FROM Dependent d " +
                "JOIN d.policyHolder ph " +
                "WHERE ph.userId = :holderId");

        query.setParameter("holderId", holderId);
        return query.getResultList();
    }

    //    Policyholder use cases with dependent
    @Override
    public Dependent retrieveOneDependent(String dependentId, String holderId) {
        Query query = entityManager.createQuery("SELECT d " +
                "FROM Dependent d " +
                "JOIN d.policyHolder ph " +
                "WHERE ph.userId = :holderId and d.id = :dependentId");

        query.setParameter("holderId", holderId);
        query.setParameter("dependentId", dependentId);
        return (Dependent) query.getSingleResult();
    }
}
