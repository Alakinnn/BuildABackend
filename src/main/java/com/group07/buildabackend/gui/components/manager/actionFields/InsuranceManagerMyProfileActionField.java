package com.group07.buildabackend.gui.components.manager.actionFields;

import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class InsuranceManagerMyProfileActionField extends ActionField {
    public InsuranceManagerMyProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
    }
}
