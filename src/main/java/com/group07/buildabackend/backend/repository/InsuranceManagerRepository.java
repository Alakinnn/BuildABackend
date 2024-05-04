package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;

public class InsuranceManagerRepository <T extends InsuranceManager> extends Repository<T>{
    public InsuranceManagerRepository() {
    }

    public void add(InsuranceClaim proposedClaim, String id){
        try{
            EM.getTransaction().begin();
            InsuranceManager im = EM.find(InsuranceManager.class, id);
            if(im != null){
                im.getProposedClaims().add(proposedClaim);
            }
            EM.persist(proposedClaim);
            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
    }

    @Override
    public void delete(T item) {

    }

    @Override
    public T retrieveById(String id) {
        return null;
    }
}
