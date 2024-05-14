package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.DTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public interface SystemUserFactory<T extends DTO, K extends SystemUser> {
    Response<K> createUser(T dto);
    void validateAndCreate(T dto, Response<K> response) throws InvalidInputException, InvalidCredentialsException;
    void setRelations(K user, Object... args);
}
