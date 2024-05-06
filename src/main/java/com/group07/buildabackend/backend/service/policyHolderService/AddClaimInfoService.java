package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.AddClaimInfoDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.io.File;
import java.util.List;

import static com.group07.buildabackend.backend.utils.fileUtils.FileListMapper.mapToDocumentList;

public class AddClaimInfoService extends PolicyHolderService {
    public static Response<InsuranceClaim> addClaimInfoService(AddClaimInfoDTO dto) {
        Response<InsuranceClaim> response = new Response<>(null);
        String claimId = dto.getClaimId();
        List<File> documents = dto.getDocuments();

        try {
            InsuranceClaim insuranceClaim = insuranceClaimRepository.retrieveById(claimId);

            if (insuranceClaim == null) {
                throw new InvalidInputException("Claim not found", 400);
            }

            if (insuranceClaim.getStatus() != InsuranceClaimStatus.INFO_MISSING) {
                throw new InvalidInputException("Can not add information to this claim", 400);
            }

            response.setData(insuranceClaim);

            if (documents.isEmpty()) {
                throw new InvalidInputException("No new document found", 400);
            }

            List<Document> documentEntityList = mapToDocumentList(documents);
            for (Document document : documentEntityList) {
                insuranceClaim.addDocument(document);
            }

            insuranceClaim.setStatus(InsuranceClaimStatus.NEW);

            insuranceClaimRepository.update(insuranceClaim);

            response.setResponseMsg("Successfully added new document(s)");

            return response;
        } catch (InvalidInputException e) {
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(e.getErrorCode());
        } catch (Exception e) {
            response.setResponseMsg(e.getMessage());
        }
        return response;
    }
}
