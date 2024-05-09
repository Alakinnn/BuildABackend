package com.group07.buildabackend.gui.components.claim.btn;

import com.group07.buildabackend.backend.controller.InsuranceManagerController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.scene.control.Button;

public class RejectClaimBtn extends Component {

    public RejectClaimBtn(String claimId) {
        Button btn = new Button();
        btn.setText("Reject Claim");
        btn.setOnAction(event -> {
            InsuranceManagerController controller = new InsuranceManagerController();
            Response<InsuranceClaim> res = controller.rejectClaim(claimId);

            if (res.getData() == null) {
                AlertManager.showError(res.getResponseMsg());
                return;
            }

            AlertManager.showInfo(res.getResponseMsg());
        });

        root = btn;
    }
}
