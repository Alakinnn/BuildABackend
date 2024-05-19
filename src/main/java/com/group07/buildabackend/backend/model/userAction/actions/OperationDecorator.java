package com.group07.buildabackend.backend.model.userAction.actions;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.userAction.operations.OperationType;

public abstract class OperationDecorator implements OperationType {
    protected OperationType operationType;

    public OperationDecorator(OperationType actionType) {
        this.operationType = actionType;
    }

    @Override
    public String getDescription() {
        return operationType.getDescription();
    }
}
