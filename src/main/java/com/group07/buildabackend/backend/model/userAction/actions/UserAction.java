package com.group07.buildabackend.backend.model.userAction.actions;

import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;

public class UserAction extends OperationDecorator{
    private SystemUserType userRole;
    public UserAction(OperationType actionType, SystemUserType userRole) {
        super(actionType);
        this.userRole = userRole;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " a " + userRole + " user";
    }
}
