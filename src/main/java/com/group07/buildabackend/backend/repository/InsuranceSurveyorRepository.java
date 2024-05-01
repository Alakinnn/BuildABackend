package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import jakarta.persistence.Query;

public class InsuranceSurveyorRepository<T extends InsuranceSurveyor> extends Repository<T>{
    public InsuranceSurveyorRepository() {
    }

    @Override
    public void delete(T item) {

    }

    @Override
    public T retrieveById(String id) {
        try{
            Query query = EM.createNamedQuery("find surveyor by id");
            query.setParameter("id", id);
            return (T) query.getSingleResult();
        } finally{
            EM.close();
        }
    }
}
