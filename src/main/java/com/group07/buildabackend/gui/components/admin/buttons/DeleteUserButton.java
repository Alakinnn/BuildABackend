package com.group07.buildabackend.gui.components.admin.buttons;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.AdminController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.scene.control.Button;

public class DeleteUserButton extends Component {
    private String userId;

    private Response<SystemUser> deleteUser() {
        AdminController controller = new AdminController();
        return controller.deleteUser(userId);
    }

    public DeleteUserButton(String userId) {
        this.userId = userId;
        Button btn = new Button();
        btn.setText("Delete");
        btn.setOnAction(event -> {
            TaskRunner<Response<SystemUser>> runner = new TaskRunner<>(this::deleteUser, res -> {
                if (!res.isOk()) {
                    AlertManager.showError(res.getResponseMsg());
                    return;
                }

                AlertManager.showInfo(res.getResponseMsg());
            });

            runner.run();
        });

        root = btn;
    }
}
