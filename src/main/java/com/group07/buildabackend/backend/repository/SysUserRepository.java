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
    public List<SysUser> retrieveClaimById(String id) {
        return null;
    }

    @Override
    public SysUser retrieveActorByEmail(String email) {
        Query query = entityManager.createQuery("FROM SysUser su WHERE su.email=:email");
        query.setParameter("email", email);
        return (SysUser) query.getSingleResult();
    }
}
