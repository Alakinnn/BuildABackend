package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import jakarta.persistence.Query;

import java.util.List;

public class InsuranceSurveyorRepository<T extends InsuranceSurveyor> extends Repository<T>{
    public InsuranceSurveyorRepository() {
    }

    @Override
    public void delete(T item) {

    }

    @Override
    public T retrieveActorById(String id) {
        try{
            Query query = entityManager.createNamedQuery("find surveyor by id");
            query.setParameter("id", id);
            return (T) query.getSingleResult();
        } finally{
            entityManager.close();
        }
    }

    @Override
    public List<T> retrieveClaimById(String id) {
        return null;
    }
}
