package com.group07.buildabackend.backend.model.userAction.actions;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.userAction.operations.OperationType;

public class AnnualCostAction extends OperationDecorator{
    public AnnualCostAction(OperationType actionType) {super(actionType);}

    @Override
    public String getDescription(){return super.getDescription() + "annual cost";}
}
