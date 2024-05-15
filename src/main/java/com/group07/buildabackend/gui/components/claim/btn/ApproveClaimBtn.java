package com.group07.buildabackend.gui.components.claim.btn;

import com.group07.buildabackend.backend.controller.InsuranceManagerController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.scene.control.Button;

public class ApproveClaimBtn extends Component {
    public ApproveClaimBtn(String claimId) {
        Button btn = new Button();
        btn.setText("Approve Claim");
        btn.setOnAction(event -> {
            InsuranceManagerController controller = new InsuranceManagerController();
            Response<InsuranceClaim> res = controller.approveClaim(claimId);

            if (res.getData() == null) {
                AlertManager.showError(res.getResponseMsg());
                return;
            }

            AlertManager.showInfo(res.getResponseMsg());
        });

        root = btn;
    }
}
