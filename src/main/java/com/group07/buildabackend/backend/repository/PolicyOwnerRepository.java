package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import jakarta.persistence.Query;

import java.util.List;

public class PolicyOwnerRepository extends Repository<PolicyOwner> {
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
    public List retrieveClaimsByUserId(String id) {
        return null;
    }
}
