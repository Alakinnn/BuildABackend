package com.group07.buildabackend.gui.components.holder.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class PolicyHolderDependentProfileActionField extends ActionField {
    public PolicyHolderDependentProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
    }
}
