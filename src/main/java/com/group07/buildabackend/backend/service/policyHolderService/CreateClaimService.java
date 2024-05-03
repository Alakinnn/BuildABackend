package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimMapper;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.validation.PolicyHolderValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.util.List;

public class CreateClaimService extends PolicyHolderService{
    private static final PolicyHolderRepository holderRepository = getHolderRepository();
    private static final ClaimRepository<InsuranceClaim> insuranceClaimRepository = getInsuranceClaimRepository();


    public static Response<InsuranceClaim> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        Response<InsuranceClaim> response = new Response<>(null);
        try {
            PolicyHolder customer = holderRepository.retrieveById(insuranceClaimDTO.getCustomerId());

            if (customer == null) {
                throw new InvalidInputException("Customer not found", 400);
            }

            PolicyHolderValidator.validateInput(insuranceClaimDTO);

            List<Document> documentEntityList = mapToDocumentList(insuranceClaimDTO.getDocuments());


            InsuranceClaim insuranceClaim = InsuranceClaimMapper.toEntity(insuranceClaimDTO);
            insuranceClaim.setCustomer(customer);

            for (Document document : documentEntityList) {
                insuranceClaim.addDocument(document);
            }

            insuranceClaimRepository.add(insuranceClaim);

            response.setData(insuranceClaim);
            response.setResponseMsg("Success");
            response.setStatusCode(200);


        } catch (InvalidInputException e) {
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(e.getErrorCode());
            response.setData(null);
        }

        return response;
    }
}