package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimMapper;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.CreateOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.UpdateOperation;
import com.group07.buildabackend.backend.validation.InsuranceClaimValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.util.List;

import static com.group07.buildabackend.backend.service.SystemUserService.policyHolderRepository;
import static com.group07.buildabackend.backend.utils.fileUtils.FileListMapper.mapToDocumentList;

public class CreateClaimService extends PolicyHolderService{
    public static Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        Response<InsuranceClaim> response = new Response<>(null);

        try {
            PolicyHolder customer = policyHolderRepository.retrieveActorById(insuranceClaimDTO.getCustomerId());

            if (customer == null) {
                throw new InvalidInputException("Customer not found", 400);
            }

            InsuranceClaimValidator.validateInput(insuranceClaimDTO);

            List<Document> documentEntityList = mapToDocumentList(insuranceClaimDTO.getDocuments());

            InsuranceClaim insuranceClaim = InsuranceClaimMapper.toEntity(insuranceClaimDTO);
            insuranceClaim.setCustomer(customer);

            for (Document document : documentEntityList) {
                insuranceClaim.addDocument(document);
            }

            OperationType userAction = new ClaimAction(new CreateOperation());
            String actionDescription = userAction.getDescription();
            response.setAction(actionDescription);

            insuranceClaimRepository.add(insuranceClaim);

            handleSuccess(response, "Successfully created claim", 200, insuranceClaim);

        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }
}
