package com.group07.buildabackend.backend.service.systemAdminService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.userAction.actions.SystemUserAction;
import com.group07.buildabackend.backend.model.userAction.operations.DeleteOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.service.user.SystemUserService;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class DeleteUserService extends SystemUserService {
    public Response<SystemUser> deleteUser(String id) {
        Response<SystemUser> response = new Response<>(null);
        OperationType userAction;
        String actionDescription;

        try {
            SystemUser systemUser = systemUserRepository.retrieveActorById(id);

            if (systemUser == null) {
                throw new InvalidInputException("User not found", 404);
            }
            SystemUserType role = systemUser.getUserType();
            userAction = new SystemUserAction(new DeleteOperation(), role);
            actionDescription = userAction.getDescription();
            response.setAction(actionDescription);

            systemUserRepository.delete(systemUser);
            handleSuccess(response, "Successfully deleted user", 200, systemUser);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } finally {
            logUserAction(CurrentUserManager.getCurrentUser().getUserId(), response.getAction(), response.getStatusCode(), response);
        }
        return response;
    }
}
