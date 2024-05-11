package com.group07.buildabackend.backend.service.userActionService;

import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.service.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogActionService extends Service {
    public static void logUserAction(String userId, String actionType, int statusCode) {
        UserAction userAction = new UserAction();
        userAction.setTimeStamp(LocalDateTime.now());
        userAction.setUserId(userId);
        userAction.setStatusCode(statusCode);
        userAction.setActionType(actionType);

        userActionRepository.add(userAction);
    }
}
