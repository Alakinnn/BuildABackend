package com.group07.buildabackend.gui.components.admin;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.admin.controllers.SystemAdminClaimListViewController;

public class SystemAdminClaimListView extends ControlledComponent<SystemAdminClaimListViewController> {
    public SystemAdminClaimListView() {
        super(SystemAdminClaimListView.class.getResource("SystemAdminClaimListView.fxml"));
    }
}
