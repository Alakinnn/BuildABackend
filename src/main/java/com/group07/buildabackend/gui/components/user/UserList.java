package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.user.controllers.UserListController;

import java.util.List;

public class UserList extends ControlledComponent<UserListController> {
    public UserList() {
        super(UserList.class.getResource("UserList.fxml"));
    }

    public void addAllUsers(List<SystemUser> users) {
        controller.addAllUsers(users);
    }
}
