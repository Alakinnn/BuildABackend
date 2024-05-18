package com.group07.buildabackend.gui.components.claim.btn;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.InsuranceClaimController;
import com.group07.buildabackend.backend.controller.PolicyOwnerController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.scene.control.Button;

public class DeleteClaimBtn extends Component {
    private String claimId;
    private Response<InsuranceClaim> deleteClaim() {
        InsuranceClaimController controller = new InsuranceClaimController();
        return controller.deleteClaim(claimId);
    }

    public DeleteClaimBtn(String claimId) {
        this.claimId = claimId;
        Button btn = new Button();
        btn.setText("Delete");
        btn.setOnAction(event -> {
            TaskRunner<Response<InsuranceClaim>> runner = new TaskRunner<>(this::deleteClaim, res -> {
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
