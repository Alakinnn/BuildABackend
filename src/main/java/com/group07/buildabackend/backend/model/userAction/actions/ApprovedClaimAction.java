package com.group07.buildabackend.backend.model.userAction.actions;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.userAction.operations.OperationType;

public class ApprovedClaimAction extends OperationDecorator{
    public ApprovedClaimAction(OperationType actionType) {super(actionType);}

    @Override
    public String getDescription() {return super.getDescription() + "successful claims";}
}
