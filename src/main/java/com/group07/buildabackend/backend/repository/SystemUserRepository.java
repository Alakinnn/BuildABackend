package com.group07.buildabackend.backend.repository;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUser;

import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.repository.operations.AllRetrievable;
import com.group07.buildabackend.backend.repository.operations.SystemUserRetrievable;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;


public class SystemUserRepository<T extends SystemUser> extends Repository<SystemUser> implements AllRetrievable<SystemUser>, SystemUserRetrievable<T> {
    @Override
    public SystemUser retrieveActorById(String id) {
        Query query = entityManager.createQuery("FROM SystemUser su WHERE su.userId=:id");
        query.setParameter("id", id);
        return (SystemUser) query.getSingleResult();
    }

    public String retrieveHashedPwdById(String id) {
        Query query = entityManager.createQuery("SELECT c.hashedPwd FROM Credentials c WHERE c.userId = :id");
        query.setParameter("id", id);
        return (String) query.getSingleResult();
    }

    public String retrieveSaltById(String id) {
        Query query = entityManager.createQuery("SELECT c.salt FROM Credentials c WHERE c.userId = :id");
        query.setParameter("id", id);
        return (String) query.getSingleResult();
    }

    public List<SystemUser> executeQueryUsers(String userQuery){
        Query query = entityManager.createQuery(userQuery);
        return query.getResultList();
    }

    public InsuranceCard executeQueryInsuranceCard(String insuranceCardQuery){
        Query query = entityManager.createQuery(insuranceCardQuery);
        return (InsuranceCard) query.getSingleResult();
    }

    public List<InsuranceClaim> executeQueryInsuranceClaim(String claimQuery){
        Query query = entityManager.createQuery(claimQuery);
        return query.getResultList();
    }

    public List<UserAction> fetchUserActionsByUserId (String userActionQuery){
        Query query = entityManager.createQuery(userActionQuery);
        return query.getResultList();
    }

    @Override
    public List<SystemUser> retrieveAll() {
        Query query = entityManager.createQuery("FROM SystemUser u");
        return query.getResultList();
    }

    @Override
    public T retrieveActorByPhone(String phoneNumber) {
        try {
            Query query = entityManager.createQuery("FROM SystemUser su WHERE su.phone=:phoneNumber");
            query.setParameter("phoneNumber", phoneNumber);
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public T retrieveActorByEmail(String email) {
        try {
            Query query = entityManager.createQuery("FROM SystemUser su WHERE su.email = :email");
            query.setParameter("email", email);
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
