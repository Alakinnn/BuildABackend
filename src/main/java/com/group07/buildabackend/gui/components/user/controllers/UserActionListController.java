package com.group07.buildabackend.gui.components.user.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class UserActionListController implements Initializable, ComponentController {
    @FXML
    private TableView<UserAction> table;
    @FXML
    private TableColumn<UserAction, String> actionCol;
    @FXML
    private TableColumn<UserAction, LocalDateTime> timeCol;
    @FXML
    private TableColumn<UserAction, Integer> statusCol;

    private String userId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actionCol.setCellValueFactory(new PropertyValueFactory<>("actionType"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("statusCode"));
    }

    private List<UserAction> fetchActions() {
        UserQueryDTO dto = new UserQueryDTO();
        dto.setSystemUserId(userId);

        UserController controller = new UserController();
        Response<List<UserAction>> res = controller.fetchUserActionsByActorId(dto);

        return res.getData();
    }

    public void initPage(String userId) {
        this.userId = userId;
        TaskRunner<List<UserAction>> runner = new TaskRunner<>(this::fetchActions, actions -> {
            if (actions == null) return;

            table.getItems().addAll(actions);
        });
        runner.run();
    }
}