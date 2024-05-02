package com.group07.buildabackend.backend.service.PolicyHolderService;

import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddClaimInfo extends PolicyHolderService {
    private static final ClaimRepository<InsuranceClaim> insuranceClaimClaimRepository = getInsuranceClaimClaimRepository();

    public static Map<InsuranceClaim, String> addClaimInfo(String claimId, List<File> documents) {
        Map<InsuranceClaim, String> serviceResponse = new HashMap<>();
        try {
            InsuranceClaim insuranceClaim = insuranceClaimClaimRepository.retrieveById(claimId);

            if (insuranceClaim == null) {
                throw new InvalidInputException("Claim not found", 400);
            }

            if (documents.isEmpty()) {
                throw new InvalidInputException("No new document found", 400);
            }

            List<Document> documentEntityList = mapToDocumentList(documents);
            for (Document document : documentEntityList) {
                insuranceClaim.addDocument(document);
            }

            insuranceClaimClaimRepository.update(insuranceClaim);
            return serviceResponse;
        } catch (InvalidInputException e) {
            serviceResponse.put(null, e.getMessage());
        }
        return serviceResponse;
    }
}
