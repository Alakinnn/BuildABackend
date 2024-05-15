package com.group07.buildabackend.gui.components.admin.controllers;

import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.user.UserList;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SystemAdminUserListViewController implements Initializable, ComponentController {
    @FXML
    private HBox usersContainer;

    UserList users;

    public SystemAdminUserListViewController() {
        users = new UserList();
    }

    private List<SystemUser> fetchUsers() {
        UserController controller = new UserController();
        return controller.retrieveAll().getData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersContainer.getChildren().add(users.getRoot());

        TaskRunner<List<SystemUser>> runner = new TaskRunner<>(this::fetchUsers, users -> {
            if (users == null) return;

            this.users.addAllUsers(users);
        });
        runner.run();
    }
}
