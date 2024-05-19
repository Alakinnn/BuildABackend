package com.group07.buildabackend.gui.components.holder.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class PolicyHolderMyProfileActionField extends ActionField {
    public PolicyHolderMyProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
    }
}
