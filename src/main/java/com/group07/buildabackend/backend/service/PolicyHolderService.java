package com.group07.buildabackend.backend.service;

import com.group07.buildabackend.backend.dto.documentDTO.DocumentDTO;
import com.group07.buildabackend.backend.dto.documentDTO.DocumentMapper;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimMapper;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.validation.PolicyHolderValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class PolicyHolderService {
    private final PolicyHolderRepository<PolicyHolder> holderRepository = new PolicyHolderRepository<>();
    private final ClaimRepository<InsuranceClaim> insuranceClaimClaimRepository = new ClaimRepository<>();

    public PolicyHolderService() {
    }

    public Map<InsuranceClaim, String> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        Map<InsuranceClaim, String> serviceResponse = new HashMap<>();

        try {
            PolicyHolder customer = holderRepository.retrieveById(insuranceClaimDTO.getCustomerId());

            if (customer == null) {
                throw new InvalidInputException("Customer not found", 400);
            }

            PolicyHolderValidator.validateInput(insuranceClaimDTO);

            List<Document> documentEntityList = mapToDocumentList(insuranceClaimDTO.getDocuments());
            insuranceClaimDTO.setMappedDocumentList(documentEntityList);

            InsuranceClaim insuranceClaim = InsuranceClaimMapper.toEntity(insuranceClaimDTO);

            serviceResponse.put(insuranceClaim, "Success");
            insuranceClaimClaimRepository.add(insuranceClaim);
        } catch (InvalidInputException e) {
            serviceResponse.put(null, e.getMessage());
        }

        return serviceResponse;
    }

    public  Map<InsuranceClaim, String> addClaimInfo(String claimId, List<File> documents) {
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

    private byte[] readFileToByteArray(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Document> mapToDocumentList(List<File> documents) {
        List<Document> documentEntityList = new ArrayList<>();
        for (File document : documents) {
            String documentPath = document.getPath();
            String documentTitle = documentPath.substring(documentPath.lastIndexOf(File.separator) + 1);
            byte[] documentByteData = readFileToByteArray(document);

            DocumentDTO documentDTO = new DocumentDTO(documentTitle, documentByteData);
            Document documentEntity = DocumentMapper.toEntity(documentDTO);
            documentEntityList.add(documentEntity);
        }

        return documentEntityList;
    }
}
