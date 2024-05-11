package com.group07.buildabackend.backend.model.userAction.actions;

import com.group07.buildabackend.backend.model.userAction.operations.OperationType;

public class ClaimAction extends OperationDecorator{
    public ClaimAction(OperationType actionType) {
        super(actionType);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "a claim";
    }
}
