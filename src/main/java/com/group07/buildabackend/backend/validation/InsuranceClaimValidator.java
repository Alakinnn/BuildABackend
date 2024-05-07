package com.group07.buildabackend.backend.validation;

import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class InsuranceClaimValidator {
    public static void validateInput(InsuranceClaimDTO insuranceClaimDTO) throws InvalidInputException {
        if (insuranceClaimDTO.getAmount() <= 0) {
            throw new InvalidInputException("Amount must be greater than 0", 400);
        }
        if (insuranceClaimDTO.getExamDate() == null) {
            throw new InvalidInputException("Exam date is required", 400);
        }
        if (insuranceClaimDTO.getReceiverBankName() == null) {
            throw new InvalidInputException("Receiver bank name is required", 400);
        }
        if (insuranceClaimDTO.getReceiverName() == null) {
            throw new InvalidInputException("Receiver name is required", 400);
        }
        if (insuranceClaimDTO.getReceiverBankNumber() == null) {
            throw new InvalidInputException("Receiver bank number is required", 400);
        }
    }
}
