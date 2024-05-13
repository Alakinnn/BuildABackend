package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimHyperlink;
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
        ROLE
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initFilter();
        initTable();
    }

    public void onFilter() {
        // TODO: implement backend
        System.out.println(filterChoice.getValue());
        System.out.println(filterValField.getText());
    }

    private void initFilter() {
        filterChoice.getItems().add(UserFilerOption.NAME.toString());
        filterChoice.getItems().add(UserFilerOption.ROLE.toString());
    }

    private void initTable() {
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("userType"));

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
