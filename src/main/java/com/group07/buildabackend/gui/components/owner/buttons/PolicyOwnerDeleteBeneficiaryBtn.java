package com.group07.buildabackend.gui.components.owner.buttons;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.AdminController;
import com.group07.buildabackend.backend.controller.PolicyOwnerController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.admin.buttons.DeleteUserButton;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.scene.control.Button;

public class PolicyOwnerDeleteBeneficiaryBtn extends Component {
    private String userId;

    private Response<Beneficiary> deleteUser() {
        PolicyOwnerController controller = new PolicyOwnerController();
        return controller.deleteBeneficiary(userId);
    }

    public PolicyOwnerDeleteBeneficiaryBtn(String userId) {
        this.userId = userId;
        Button btn = new Button();
        btn.setText("Delete");
        btn.setOnAction(event -> {
            TaskRunner<Response<Beneficiary>> runner = new TaskRunner<>(this::deleteUser, res -> {
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
