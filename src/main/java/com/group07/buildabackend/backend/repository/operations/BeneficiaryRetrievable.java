package com.group07.buildabackend.backend.repository.operations;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;

import java.util.List;

public interface BeneficiaryRetrievable<T extends Beneficiary> {
    T retrieveOneBeneficiary(String beneficiaryId, String ownerId);
    List<T> retrieveAllBeneficiary(String ownerId);
    InsuranceClaim retrieveOneBeneficiaryClaim(String claimId, String ownerId, String beneficiaryId);
    List<InsuranceClaim> retrieveAllBeneficiaryClaim(String ownerId, String beneficiaryId);
}
