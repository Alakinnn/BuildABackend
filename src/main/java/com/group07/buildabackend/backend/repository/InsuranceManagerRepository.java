package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;

import java.util.List;

public class InsuranceManagerRepository extends Repository<InsuranceManager>{
    public InsuranceManagerRepository() {
    }

    public void add(InsuranceClaim proposedClaim, String id){
        try{
            entityManager.getTransaction().begin();
            InsuranceManager im = entityManager.find(InsuranceManager.class, id);
            if(im != null){
                im.getProposedClaims().add(proposedClaim);
            }
            entityManager.persist(proposedClaim);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(InsuranceManager item) {

    }

    @Override
    public InsuranceManager retrieveActorById(String id) {
        return null;
    }
}
