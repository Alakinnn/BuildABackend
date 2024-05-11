package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.AddClaimInfoDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.CreateOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.UpdateOperation;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.io.File;
import java.util.List;

import static com.group07.buildabackend.backend.utils.fileUtils.FileListMapper.mapToDocumentList;

public class AddClaimInfoService extends PolicyHolderService {
    public static Response<InsuranceClaim> addClaimInfoService(AddClaimInfoDTO dto) {
        Response<InsuranceClaim> response = new Response<>(null);
        String claimId = dto.getId();
        List<File> documents = dto.getDocuments();

        try {
            InsuranceClaim insuranceClaim = insuranceClaimRepository.retrieveActorById(claimId);

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

            OperationType userAction = new ClaimAction(new UpdateOperation());
            String actionDescription = userAction.getDescription();
            response.setAction(actionDescription);

            insuranceClaimRepository.update(insuranceClaim);

            handleSuccess(response, "Successfully added new document(s)", 200, insuranceClaim);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }
        return response;
    }
}
