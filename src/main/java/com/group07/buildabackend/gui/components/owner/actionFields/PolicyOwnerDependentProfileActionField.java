package com.group07.buildabackend.gui.components.owner.actionFields;

import com.group07.buildabackend.gui.components.holder.buttons.PolicyHolderDeleteDependentBtn;
import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.pages.Page;

public class PolicyOwnerDependentProfileActionField extends ActionField {
    public PolicyOwnerDependentProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
        addButton(new PolicyHolderDeleteDependentBtn(userId).getRoot());
    }
}
