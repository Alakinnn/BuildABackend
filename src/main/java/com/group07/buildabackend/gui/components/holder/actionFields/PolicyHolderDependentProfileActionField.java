package com.group07.buildabackend.gui.components.holder.actionFields;

import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class PolicyHolderDependentProfileActionField extends ActionField {
    public PolicyHolderDependentProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
    }
}
