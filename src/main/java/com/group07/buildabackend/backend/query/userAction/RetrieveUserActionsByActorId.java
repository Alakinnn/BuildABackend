package com.group07.buildabackend.backend.query.userAction;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.dto.userActionDTO.UserActionDTO;
import com.group07.buildabackend.backend.model.userAction.UserAction;

import java.util.List;

public class RetrieveUserActionsByActorId extends UserActionQuery{
    private UserActionQuery userActionQuery;
    private String systemUserId;

    public RetrieveUserActionsByActorId(UserActionQuery userActionQuery, String systemUserId) {
        this.userActionQuery = userActionQuery;
        this.systemUserId = systemUserId;
    }

    @Override
    public String toString() {
        return userActionQuery + "WHERE ua.systemUser.userId LIKE '%" + systemUserId + "%'";
    }
}