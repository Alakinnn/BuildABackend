package com.group07.buildabackend.backend.service.user;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.user.UpdateUserDTO;
import com.group07.buildabackend.backend.model.SystemUser;

import com.group07.buildabackend.backend.model.userAction.actions.SystemUserAction;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.model.userAction.operations.UpdateOperation;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class UpdateUserService extends SystemUserService {
    public static Response<SystemUser> updateUser(UpdateUserDTO dto) {
        Response<SystemUser> response = new Response<>(null);
        OperationType userAction = new SystemUserAction(new UpdateOperation(), CurrentUserManager.getCurrentUser().getUserType());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        try{
            SystemUserRepository repo = new SystemUserRepository();
            SystemUser user = repo.retrieveActorById(dto.getUserId());

            if(user == null){
                throw new InvalidInputException("User not found", 404);
            }

            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setEmail(dto.getEmail());
            user.setAddress(dto.getAddress());
            user.setPhone(dto.getPhone());

            UserCredentialsService.updateCredentials(dto.getPassword(), user);

            repo.update(user);
            handleSuccess(response, "Successfully updated user", 200, user);
        } catch (InvalidInputException e){
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
        }

        return response;
    }
}
