package com.group07.buildabackend.backend.repository.operations;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;

import java.util.List;

public interface ClaimRetrievable<T extends InsuranceClaim> {
    List<T> retrieveAllClaimsByActorId(String id);
    InsuranceClaim retrieveOneClaimByActorId(String claimId, String systemUserId);
}
