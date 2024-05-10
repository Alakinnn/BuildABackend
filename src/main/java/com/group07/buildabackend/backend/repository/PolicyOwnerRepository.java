package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.operations.BeneficiaryRetrievable;
import com.group07.buildabackend.backend.repository.operations.ClaimRetrievable;
import jakarta.persistence.Query;

import java.util.List;

public class PolicyOwnerRepository extends Repository<PolicyOwner> implements ClaimRetrievable<InsuranceClaim>, BeneficiaryRetrievable<Beneficiary> {
    @Override
    public void delete(PolicyOwner item) {

    }

    @Override
    public PolicyOwner retrieveActorById(String id) {
        Query query = entityManager.createQuery("FROM PolicyOwner po WHERE po.id=:id");
        query.setParameter("id", id);
        return (PolicyOwner) query.getSingleResult();
    }

    @Override
    public Beneficiary retrieveOneBeneficiary(String beneficiaryId, String ownerId) {
        Query query = entityManager.createQuery("SELECT b " +
                "FROM Beneficiary b " +
                "WHERE b.policyOwner.userId = :ownerId and b.userId = :beneficiaryId");
        query.setParameter("ownerId", ownerId);
        query.setParameter("beneficiaryId", beneficiaryId);

        return (Beneficiary) query.getSingleResult();
    }

    @Override
    public List<Beneficiary> retrieveAllBeneficiary(String ownerId) {
        Query query = entityManager.createQuery("SELECT b " +
                "FROM Beneficiary b " +
                "WHERE b.policyOwner.userId = :ownerId");
        query.setParameter("ownerId", ownerId);

        return query.getResultList();
    }

    @Override
    public InsuranceClaim retrieveOneBeneficiaryClaim(String claimId, String ownerId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN Beneficiary b on ic.customer.id = b.id WHERE b.policyOwner.userId = :ownerId AND ic.id = :claimId");
        query.setParameter("ownerId", ownerId);
        query.setParameter("claimId", claimId);

        return (InsuranceClaim) query.getSingleResult();
    }

    @Override
    public List<InsuranceClaim> retrieveAllBeneficiaryClaim(String ownerId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN Beneficiary b on ic.customer.id = b.id WHERE b.policyOwner.userId = :ownerId");
        query.setParameter("ownerId", ownerId);

        return query.getResultList();
    }

    @Override
    public List<InsuranceClaim> retrieveAllClaimsByActorId(String id) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN PolicyOwner po on ic.customer.id = po.id WHERE po.id = :poId");
        query.setParameter("poId", id);

        return query.getResultList();
    }
}