package com.group07.buildabackend.backend.repository.operations;

import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;

import java.util.List;

public interface DependentRetrievable<T extends Dependent> {
    T retrieveOneDependent(String dependentId, String holderId);
    List<T> retrieveAllDependent(String holderId);
    InsuranceClaim retrieveOneDependentClaim(String claimId, String holderId);
    List<InsuranceClaim> retrieveAllDependentClaim(String holderId);
 }
