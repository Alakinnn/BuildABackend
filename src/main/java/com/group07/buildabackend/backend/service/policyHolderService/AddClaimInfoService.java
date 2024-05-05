package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.io.File;
import java.util.List;

import static com.group07.buildabackend.backend.utils.fileUtils.FileListMapper.mapToDocumentList;

public class AddClaimInfoService extends PolicyHolderService {
    public static Response<InsuranceClaim> addClaimInfoService(String claimId, List<File> documents) {
        Response<InsuranceClaim> response = new Response<>(null);
        try {
            InsuranceClaim insuranceClaim = insuranceClaimRepository.retrieveById(claimId);

            if (insuranceClaim == null) {
                throw new InvalidInputException("Claim not found", 400);
            }

            response.setData(insuranceClaim);

            if (documents.isEmpty()) {
                throw new InvalidInputException("No new document found", 400);
            }

            List<Document> documentEntityList = mapToDocumentList(documents);
            for (Document document : documentEntityList) {
                insuranceClaim.addDocument(document);
            }

            insuranceClaimRepository.update(insuranceClaim);
            return response;
        } catch (InvalidInputException e) {
            response.setData(null);
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(e.getErrorCode());
        }
        return response;
    }
}
