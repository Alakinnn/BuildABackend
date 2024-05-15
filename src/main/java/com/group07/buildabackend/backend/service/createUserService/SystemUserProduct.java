package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.DTO;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.userAction.actions.SystemUserAction;
import com.group07.buildabackend.backend.model.userAction.operations.CreateOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import static com.group07.buildabackend.backend.service.Service.handleException;
import static com.group07.buildabackend.backend.service.userActionService.LogActionService.logUserAction;

public interface SystemUserProduct<T extends DTO, K extends com.group07.buildabackend.backend.model.SystemUser> {

    void validateAndCreate(T dto, Response<K> response) throws InvalidInputException, InvalidCredentialsException;

    void setRelations(K user, Object... args);

    default Response<K> execute(T dto, SystemUserType systemUserType) {
        Response<K> response = new Response<>(null);
        OperationType userAction = new SystemUserAction(new CreateOperation(), systemUserType);
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);
        try {
            validateAndCreate(dto, response);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), 400);
        } catch (InvalidCredentialsException e) {
            handleException(response, e.getMessage(), 400);
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
        }
        return response;
    }
};

