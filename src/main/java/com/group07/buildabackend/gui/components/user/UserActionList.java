package com.group07.buildabackend.gui.components.user;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.user.controllers.UserActionListController;

public class UserActionList extends ControlledComponent<UserActionListController> {
    public UserActionList(String userId) {
        super(UserActionList.class.getResource("UserActionList.fxml"));
        controller.initPage(userId);
    }
}
