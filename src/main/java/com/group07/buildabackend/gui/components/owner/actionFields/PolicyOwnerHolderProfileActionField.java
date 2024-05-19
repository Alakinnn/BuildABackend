package com.group07.buildabackend.gui.components.owner.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.owner.buttons.PolicyOwnerDeleteBeneficiaryBtn;
import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class PolicyOwnerHolderProfileActionField extends ActionField {
    public PolicyOwnerHolderProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
        addButton(new PolicyOwnerDeleteBeneficiaryBtn(userId).getRoot());
    }
}
