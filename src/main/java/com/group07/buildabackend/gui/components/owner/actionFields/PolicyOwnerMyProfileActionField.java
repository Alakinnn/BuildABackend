package com.group07.buildabackend.gui.components.owner.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class PolicyOwnerMyProfileActionField extends ActionField {
    public PolicyOwnerMyProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
    }
}
