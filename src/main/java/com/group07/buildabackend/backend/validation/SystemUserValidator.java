package com.group07.buildabackend.backend.validation;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.authenticationDTO.RegisterInfoDTO;
import com.group07.buildabackend.backend.service.user.SystemUserService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class SystemUserValidator extends SystemUserService {
    public static void validateInput(RegisterInfoDTO registerInfoDTO) throws InvalidInputException {
        if (registerInfoDTO.getAddress() == null) {
            throw new InvalidInputException("Address is required", 400);
        }

        if (registerInfoDTO.getEmail() == null) {
            throw new InvalidInputException("Email is required", 400);
        }

        if (systemUserRepository.retrieveActorByEmail(registerInfoDTO.getEmail()) != null) {
            throw new InvalidInputException("Email already exists", 400);
        }

        if (registerInfoDTO.getFirstName() == null) {
            throw new InvalidInputException("First name is required", 400);
        }

        if (registerInfoDTO.getLastName() == null) {
            throw new InvalidInputException("Last name is required", 400);
        }

        if (registerInfoDTO.getPhone() == null) {
            throw new InvalidInputException("Phone number is required", 400);
        }

        if (systemUserRepository.retrieveActorByPhone(registerInfoDTO.getPhone()) != null) {
            throw new InvalidInputException("Phone number already exists", 400);
        }

        if (registerInfoDTO.getPwd() == null) {
            throw new InvalidInputException("Password is required", 400);
        }
    }
}
