package com.group07.buildabackend.gui.components.admin.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.admin.buttons.DeleteUserButton;
import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class SystemAdminPublicProfileActionField extends ActionField {
    public SystemAdminPublicProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
        addButton(new DeleteUserButton(userId).getRoot());
    }
}
