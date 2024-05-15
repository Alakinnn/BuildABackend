package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.SystemUser;

import com.group07.buildabackend.backend.model.systemAdmin.SystemAdmin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;


public class SystemUserRepository extends Repository<SystemUser> {
    @Override
    public void delete(SystemUser item) {

    }

    @Override
    public SystemUser retrieveActorById(String id) {
        Query query = entityManager.createQuery("FROM SystemUser su WHERE su.userId=:id");
        query.setParameter("id", id);
        return (SystemUser) query.getSingleResult();
    }


    @Override
    public SystemUser retrieveActorByEmail(String email) {
        Query query = entityManager.createQuery("FROM SystemUser su WHERE su.email=:email");
        query.setParameter("email", email);
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

    public List<SystemUser> excecuteQuery(String userQuery){
        Query query = entityManager.createQuery(userQuery);
        return query.getResultList();
    }
}
