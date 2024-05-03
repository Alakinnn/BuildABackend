package com.group07.buildabackend.backend.service.policyHolderService;

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
    private static final PolicyHolderRepository<PolicyHolder> holderRepository = new PolicyHolderRepository<>();
    private static final ClaimRepository<InsuranceClaim> insuranceClaimRepository = new ClaimRepository<>();

    public static PolicyHolderRepository<PolicyHolder> getHolderRepository() {
        return holderRepository;
    }

    public static ClaimRepository<InsuranceClaim> getInsuranceClaimRepository() {
        return insuranceClaimRepository;
    }

     static byte[] readFileToByteArray(File file) {
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
         for (int i = 0; i < documents.toArray().length; i++) {
             File document = documents.get(i);
             String documentPath = document.getPath();
             String documentTitle = documentPath.substring(documentPath.lastIndexOf(File.separator) + 1);
             byte[] documentByteData = readFileToByteArray(document);

             DocumentDTO documentDTO = new DocumentDTO();
             documentDTO.setId(i + 3);
             documentDTO.setTitle(documentTitle);
             documentDTO.setUrl(documentByteData);

             Document documentEntity = DocumentMapper.toEntity(documentDTO);
             documentEntityList.add(documentEntity);
         }

        return documentEntityList;
    }
}
