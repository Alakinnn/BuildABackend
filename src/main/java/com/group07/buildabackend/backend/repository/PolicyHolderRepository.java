package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
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
        try {
            Query query = EM.createQuery("FROM PolicyHolder ph WHERE ph.id=:id");
            query.setParameter("id", id);
            return (T) query.getSingleResult();
        } finally {
            EM.close();
        }
    }



}
