package com.group07.buildabackend.backend.model.userAction.actions;

import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;

public class UserAction extends OperationDecorator{
    private SystemUserType systemUserType;
    public UserAction(OperationType actionType, SystemUserType systemUserType) {
        super(actionType);
        this.systemUserType = systemUserType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "a " + systemUserType;
    }
}
