package com.group07.buildabackend.backend.service.PolicyHolderService;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimMapper;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.validation.PolicyHolderValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateClaimService extends PolicyHolderService{
    private static final PolicyHolderRepository holderRepository = getHolderRepository();
    private static final ClaimRepository<InsuranceClaim> insuranceClaimClaimRepository = getInsuranceClaimClaimRepository();


    public static Map<InsuranceClaim, String> createClaim(InsuranceClaimDTO insuranceClaimDTO) {
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
}
