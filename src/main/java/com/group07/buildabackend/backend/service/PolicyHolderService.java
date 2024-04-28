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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PolicyHolderService {
    private final PolicyHolderRepository<PolicyHolder> holderRepository = new PolicyHolderRepository<>();
    private final ClaimRepository<InsuranceClaim> insuranceClaimClaimRepository = new ClaimRepository<>();

    public PolicyHolderService() {
    }

    public InsuranceClaim createClaim(String customerId, String receiverBankName, String receiverBankNumber, String receiverName, double claimAmount, String examDate, List<File> documents) {
        PolicyHolder customer = holderRepository.retrieveById(customerId);
        if (customer == null) {
//            EXCEPTION HERE
        }

        List<Document> documentEntityList = mapToDocumentList(documents);

        InsuranceClaimDTO insuranceClaimDTO = new InsuranceClaimDTO(claimAmount, LocalDate.parse(examDate), receiverBankName, receiverBankNumber, receiverName, customer);

        insuranceClaimDTO.setDocuments(documentEntityList);

        InsuranceClaim insuranceClaim = InsuranceClaimMapper.toEntity(insuranceClaimDTO);


        insuranceClaimClaimRepository.add(insuranceClaim);
        return insuranceClaim;
    }

    public InsuranceClaim addClaimInfo(String claimId, List<File> documents) {
        InsuranceClaim insuranceClaim = insuranceClaimClaimRepository.retrieveById(claimId);
        if (insuranceClaim == null) {
//            EXCEPTION HERE
        }

        List<Document> documentEntityList = mapToDocumentList(documents);
        for (Document document : documentEntityList) {
            insuranceClaim.addDocument(document);
        }

        insuranceClaimClaimRepository.update(insuranceClaim);
        return insuranceClaim;
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
