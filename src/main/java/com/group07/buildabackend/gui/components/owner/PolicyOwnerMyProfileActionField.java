package com.group07.buildabackend.gui.components.owner;

import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class PolicyOwnerMyProfileActionField extends ActionField {
    public PolicyOwnerMyProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
    }
}
