package com.group07.buildabackend.backend.repository;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.PolicyOwnerController;
import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.operations.BeneficiaryRetrievable;
import com.group07.buildabackend.backend.repository.operations.ClaimRetrievable;
import jakarta.persistence.Query;

import java.util.List;

public class PolicyOwnerRepository extends SystemUserRepository<PolicyOwner> implements ClaimRetrievable<InsuranceClaim>, BeneficiaryRetrievable<Beneficiary> {

    @Override
    public PolicyOwner retrieveActorById(String id) {
        Query query = entityManager.createQuery("FROM PolicyOwner po WHERE po.id=:id");
        query.setParameter("id", id);
        return (PolicyOwner) query.getSingleResult();
    }

    @Override
    public List<Beneficiary> retrieveAllBeneficiary(String ownerId) {
        Query query = entityManager.createQuery("SELECT b " +
                "FROM Beneficiary b " +
                "WHERE b.policyOwner.userId = :ownerId");
        query.setParameter("ownerId", ownerId);

        return query.getResultList();
    }

    public List<PolicyHolder> retrieveAllPolicyHolders(String ownerId) {
        Query query = entityManager.createQuery("SELECT ph " +
                "FROM PolicyHolder ph " +
                "LEFT JOIN Beneficiary b ON ph.userId=b.userId " +
                "WHERE b.policyOwner.userId=:ownerId");
        query.setParameter("ownerId", ownerId);

        return query.getResultList();
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
    public List<InsuranceClaim> retrieveAllBeneficiaryClaim(String ownerId, String beneficiaryId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN Beneficiary b on ic.customer.id = b.id WHERE b.policyOwner.userId = :ownerId AND b.id = :beneficiaryId");
        query.setParameter("ownerId", ownerId);
        query.setParameter("beneficiaryId", beneficiaryId);

        return query.getResultList();
    }

    @Override
    public InsuranceClaim retrieveOneBeneficiaryClaim(String claimId, String ownerId, String beneficiaryId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN Beneficiary b ON ic.customer.userId = b.id WHERE ic.id = :claimId AND b.id = :beneficiaryId AND b.policyOwner.userId = :ownerId");
        query.setParameter("claimId", claimId);
        query.setParameter("beneficiaryId", beneficiaryId);
        query.setParameter("ownerId", ownerId);

        return (InsuranceClaim) query.getResultList();
    }

    @Override
    public List<InsuranceClaim> retrieveAllClaimsByActorId(String id) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN PolicyOwner po on ic.customer.id = po.id WHERE po.id = :poId");
        query.setParameter("poId", id);

        return query.getResultList();
    }

    @Override
    public InsuranceClaim retrieveOneClaimByActorId(String claimId, String systemUserId) {
        Query query = entityManager.createQuery("FROM InsuranceClaim ic JOIN PolicyOwner po on ic.customer.id = po.id where po.id = :poId AND ic.id = :claimId");
        query.setParameter("poId", systemUserId);
        query.setParameter("claimId", claimId);

        return (InsuranceClaim) query.getResultList();
    }

    public double getYearlyRate(String ownerId) {
        Query query = entityManager.createQuery("SELECT o.yearlyRate FROM PolicyOwner o WHERE o.userId='" + ownerId + "'");

        return (double) query.getSingleResult();
    }

    @Override
    public List<SystemUser> retrieveAll() {
        Query query = entityManager.createQuery("FROM SystemUser u WHERE u.userType=policy_owner");

        return query.getResultList();
    }
}
