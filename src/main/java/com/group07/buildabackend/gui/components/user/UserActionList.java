package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.user.controllers.UserActionListController;

public class UserActionList extends ControlledComponent<UserActionListController> {
    public UserActionList(String userId) {
        super(UserActionList.class.getResource("UserActionList.fxml"));
        controller.initPage(userId);
    }
}
