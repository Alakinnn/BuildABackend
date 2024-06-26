package com.group07.buildabackend.backend.model.userAction.actions;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;

public class SystemUserAction extends OperationDecorator{
    private SystemUserType systemUserType;
    public SystemUserAction(OperationType actionType, SystemUserType systemUserType) {
        super(actionType);
        this.systemUserType = systemUserType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "a " + systemUserType;
    }
}
