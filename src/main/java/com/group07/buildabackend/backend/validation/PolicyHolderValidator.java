package com.group07.buildabackend.backend.validation;

import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class PolicyHolderValidator {
    public static void validateInput(PolicyHolderDTO policyHolderDTO) throws InvalidInputException {
        if (policyHolderDTO.getAddress() == null) {
            throw new InvalidInputException("Address is required", 400);
        }

        if (policyHolderDTO.getEmail() == null) {
            throw new InvalidInputException("Email is required", 400);
        }

        if (policyHolderDTO.getFirstName() == null) {
            throw new InvalidInputException("First name is required", 400);
        }

        if (policyHolderDTO.getLastName() == null) {
            throw new InvalidInputException("Last name is required", 400);
        }

        if (policyHolderDTO.getPhone() == null) {
            throw new InvalidInputException("Phone number is required", 400);
        }

        if (policyHolderDTO.getPwd() == null) {
            throw new InvalidInputException("Password is required", 400);
        }

    }
}
