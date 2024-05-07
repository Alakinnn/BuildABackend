package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.SysUser;
import jakarta.persistence.Query;

import java.util.List;

public class SysUserRepository extends Repository<SysUser> {
    @Override
    public void delete(SysUser item) {

    }

    @Override
    public SysUser retrieveActorById(String id) {
        return null;
    }

    @Override
    public List<SysUser> retrieveClaimsByUserId(String id) {
        return null;
    }

    @Override
    public SysUser retrieveActorByEmail(String email) {
        Query query = entityManager.createQuery("FROM SysUser su WHERE su.email=:email");
        query.setParameter("email", email);
        return (SysUser) query.getSingleResult();
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
}
