package com.group07.buildabackend.backend.service.userActionService;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.service.Service;
import com.group07.buildabackend.backend.validation.ActionValidator;
import com.group07.buildabackend.backend.validation.customExceptions.ActionLoggingException;

import java.time.LocalDateTime;

public class LogActionService extends Service {
    public static void logUserAction(String userId, String actionType, int statusCode, Response response) {
        try {
            UserAction userAction = new UserAction();
            userAction.setTimeStamp(LocalDateTime.now().withNano(0));
            SystemUser systemUser = systemUserRepository.retrieveActorById(userId);

            if (systemUser == null) {
                throw new ActionLoggingException("There is something wrong right now, please check again later", 500);
            }
            userAction.setSystemUser(systemUser);
            userAction.setStatusCode(statusCode);
            userAction.setActionType(actionType);

            ActionValidator.validateAction(userAction);
            userActionRepository.add(userAction);
        } catch (ActionLoggingException e) {
            response.setData(null);
            handleException(response, e.getMessage(), e.getErrorCode());
        }
    }

}
