package com.group07.buildabackend.gui.components.admin;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.admin.controllers.SystemAdminUserListViewController;

public class SystemAdminUserListView extends ControlledComponent<SystemAdminUserListViewController> {
    public SystemAdminUserListView() {
        super(SystemAdminUserListView.class.getResource("SystemAdminUserListView.fxml"));
    }
}
