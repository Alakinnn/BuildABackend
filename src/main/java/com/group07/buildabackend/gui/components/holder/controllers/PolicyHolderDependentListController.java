package com.group07.buildabackend.gui.components.holder.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
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

public class PolicyHolderDependentListController implements Initializable, ComponentController {
    @FXML
    private HBox myDependentsContainer;

    private UserList myDependents;

    private String phId;

    public PolicyHolderDependentListController() {
        this.myDependents = new UserList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myDependentsContainer.getChildren().add(myDependents.getRoot());
    }

    private List<SystemUser> fetchDependents() {
        PolicyHolderRepository repo = new PolicyHolderRepository();
        List<Dependent> dependents = repo.retrieveAllDependent(phId);

        List<SystemUser> res = new ArrayList<>(dependents.size());
        res.addAll(dependents);
        return res;
    }

    public void initPage(String phId) {
        this.phId = phId;

        TaskRunner<List<SystemUser>> runner = new TaskRunner<>(this::fetchDependents, users -> {
            myDependents.addAllUsers(users);
        });
        runner.run();
    }


}
