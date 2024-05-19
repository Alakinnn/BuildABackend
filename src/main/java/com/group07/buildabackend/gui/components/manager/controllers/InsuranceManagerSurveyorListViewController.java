package com.group07.buildabackend.gui.components.manager.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.InsuranceSurveyorController;
import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.user.UserList;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InsuranceManagerSurveyorListViewController implements ComponentController, Initializable {
    @FXML
    private HBox surveyorsContainer;

    UserList surveyors;

    public InsuranceManagerSurveyorListViewController() {
        surveyors = new UserList();
    }

    private List<SystemUser> fetchUsers() {
        InsuranceSurveyorController controller = new InsuranceSurveyorController();
        return controller.retrieveAll().getData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        surveyorsContainer.getChildren().add(surveyors.getRoot());

        TaskRunner<List<SystemUser>> runner = new TaskRunner<>(this::fetchUsers, users -> {
            if (users == null) return;

            this.surveyors.addAllUsers(users);
        });
        runner.run();
    }
}
