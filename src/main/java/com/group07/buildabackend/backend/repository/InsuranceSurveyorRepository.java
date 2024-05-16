package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import jakarta.persistence.Query;

import java.util.List;

public class InsuranceSurveyorRepository extends SystemUserRepository<InsuranceSurveyor>{
    public InsuranceSurveyorRepository() {
    }

    @Override
    public InsuranceSurveyor retrieveActorById(String id) {
        try{
            Query query = entityManager.createNamedQuery("find surveyor by id");
            query.setParameter("id", id);
            return (InsuranceSurveyor) query.getSingleResult();
        } finally{
            entityManager.close();
        }
    }

    @Override
    public List<SystemUser> retrieveAll() {
        Query query = entityManager.createQuery("FROM SystemUser u WHERE u.userType='insurance_surveyor'");
        return query.getResultList();
    }

}
