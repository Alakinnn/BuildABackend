package com.group07.buildabackend.gui.components.admin.actionFields;

import com.group07.buildabackend.gui.components.admin.buttons.SystemAdminDeleteUserButton;
import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class SystemAdminPublicProfileActionField extends ActionField {
    public SystemAdminPublicProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
        addButton(new SystemAdminDeleteUserButton().getRoot());
    }
}
