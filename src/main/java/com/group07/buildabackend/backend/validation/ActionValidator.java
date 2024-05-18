package com.group07.buildabackend.backend.validation;
/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.validation.customExceptions.ActionLoggingException;

public class ActionValidator {
    public static void validateAction(UserAction userAction) throws ActionLoggingException {
        if (userAction.getStatusCode() == 0) {
            throw new ActionLoggingException("There is something wrong right now, please check again later", 500);
        }
        if (userAction.getActionType() == null) {
            throw new ActionLoggingException("There is something wrong right now, please check again later", 500);
        }
    }
}
