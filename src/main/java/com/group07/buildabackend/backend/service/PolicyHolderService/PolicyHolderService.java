package com.group07.buildabackend.backend.service.PolicyHolderService;

import com.group07.buildabackend.backend.dto.documentDTO.DocumentDTO;
import com.group07.buildabackend.backend.dto.documentDTO.DocumentMapper;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class PolicyHolderService {
    private final PolicyHolderRepository<PolicyHolder> holderRepository = new PolicyHolderRepository<>();
    private final ClaimRepository<InsuranceClaim> insuranceClaimClaimRepository = new ClaimRepository<>();

    public static PolicyHolderRepository<PolicyHolder> getHolderRepository() {
        return holderRepository;
    }

    public static ClaimRepository<InsuranceClaim> getInsuranceClaimClaimRepository() {
        return insuranceClaimClaimRepository;
    }

     byte[] readFileToByteArray(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     static List<Document> mapToDocumentList(List<File> documents) {
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
