package com.group07.buildabackend.gui.components.user.controllers;

import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimHyperlink;
import com.group07.buildabackend.gui.components.user.UserHyperlink;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserListController implements Initializable, ComponentController {
    @FXML
    private TableView<SystemUser> table;
    @FXML
    private TableColumn<SystemUser, Hyperlink> idCol;
    @FXML
    private TableColumn<SystemUser, String> fullNameCol;
    @FXML
    private TableColumn<SystemUser, SystemUserType> roleCol;
    @FXML
    private TableColumn<SystemUser, String> emailCol;
    @FXML
    private ChoiceBox<String> filterChoice;
    @FXML
    private TextField filterValField;

    private enum UserFilerOption {
        NAME,
        EMAIL,
        ROLE
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initFilter();
        initTable();
    }

    private List<SystemUser> fetchUsers() {
        UserController controller = new UserController();

        UserFilerOption filter = UserFilerOption.valueOf(filterChoice.getValue());
        String filterVal = filterValField.getText();

        UserQueryDTO dto = new UserQueryDTO();
        return switch (filter) {
            case NAME:
                dto.setNameVal(filterVal);
                yield controller.fetchUsersByName(dto).getData();
            case EMAIL:
                dto.setEmail(filterVal);
                yield controller.fetchUsersByEmail(dto).getData();
            case ROLE:
                dto.setUserType(filterVal);
                yield controller.fetchUsersByUserType(dto).getData();
        };
    }

    public void onFilter() {
        if (filterChoice.getValue() == null || filterValField.getText() == null) return;

        table.getItems().clear();
        TaskRunner<List<SystemUser>> runner = new TaskRunner<>(this::fetchUsers, this::addAllUsers);
        runner.run();
    }

    private void initFilter() {
        filterChoice.getItems().add(UserFilerOption.NAME.toString());
        filterChoice.getItems().add(UserFilerOption.EMAIL.toString());
        filterChoice.getItems().add(UserFilerOption.ROLE.toString());
    }

    private void initTable() {
        emailCol.setCellValueFactory(cellData -> {
            SystemUser user = cellData.getValue();
            return new javafx.beans.property.ReadOnlyObjectWrapper<>(user.getEmail());
        });

        roleCol.setCellValueFactory(cellData -> {
            SystemUser user = cellData.getValue();
            return new javafx.beans.property.ReadOnlyObjectWrapper<>(user.getUserType());
        });

        idCol.setCellValueFactory(cellData -> {
            SystemUser user = cellData.getValue();
            Hyperlink link = (Hyperlink) new UserHyperlink(user).getRoot();

            return new javafx.beans.property.ReadOnlyObjectWrapper<>(link);
        });

        fullNameCol.setCellValueFactory(cellData -> {
            SystemUser user = cellData.getValue();
            return new javafx.beans.property.ReadOnlyObjectWrapper<>(user.getFullName());
        });


    }

    public void addUser(SystemUser user) {
        table.getItems().add(user);
    }

    public void addAllUsers(List<SystemUser> users) {
        if (users == null) return;
        table.getItems().addAll(users);
    }
}
