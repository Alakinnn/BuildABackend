package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimMapper;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.validation.InsuranceClaimValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.util.List;

import static com.group07.buildabackend.backend.utils.fileUtils.FileListMapper.mapToDocumentList;

public class CreateClaimService extends PolicyHolderService{
    public static Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        Response<InsuranceClaim> response = new Response<>(null);

        try {
            // Find the customer
            PolicyHolder customer = holderRepository.retrieveActorById(insuranceClaimDTO.getCustomerId());

            if (customer == null) {
                throw new InvalidInputException("Customer not found", 400);
            }

            // Validate inputs
            InsuranceClaimValidator.validateInput(insuranceClaimDTO);

            // Upload documents
            List<Document> documentEntityList = mapToDocumentList(insuranceClaimDTO.getDocuments());

            // Map to entity
            InsuranceClaim insuranceClaim = InsuranceClaimMapper.toEntity(insuranceClaimDTO);
            insuranceClaim.setCustomer(customer);

            // Add documents to entity
            for (Document document : documentEntityList) {
                insuranceClaim.addDocument(document);
            }

            // Add new claim to DB
            insuranceClaimRepository.add(insuranceClaim);

            // Return response
            response.setData(insuranceClaim);
            response.setResponseMsg("Success");
            response.setStatusCode(200);

        } catch (InvalidInputException e) {
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(e.getErrorCode());
            response.setData(null);
        } catch (Exception e) {
            response.setResponseMsg(e.getMessage());
            response.setData(null);
        }

        return response;
    }
}
