package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import jakarta.persistence.Query;

import java.util.List;

public class PolicyHolderRepository<T extends PolicyHolder> extends Repository<T>{
    public PolicyHolderRepository() {
    }



    @Override
    public void delete(T item) {

    }

    @Override
    public T retrieveById(String id) {
            Query query = entityManager.createQuery("FROM Beneficiary be WHERE be.id=:id");
            query.setParameter("id", id);
            return (T) query.getSingleResult();
    }

    @Override
    public void add(T item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }



}
