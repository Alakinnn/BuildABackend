package com.group07.buildabackend.gui.components.claim.btn;

import com.group07.buildabackend.backend.controller.InsuranceSurveyorController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.ProposeClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.scene.control.Button;

public class ProposeClaimBtn extends Component {

    public ProposeClaimBtn(String claimId) {
        Button btn = new Button();
        btn.setText("Propose Claim");
        btn.setOnAction(event -> {
            InsuranceSurveyorController controller = new InsuranceSurveyorController();

            ProposeClaimDTO dto = new ProposeClaimDTO();
            dto.setClaimId(claimId);

            Response<InsuranceClaim> res = controller.proposeClaim(dto);

            if (res.getData() == null) {
                AlertManager.showError(res.getResponseMsg());
                return;
            }

            AlertManager.showInfo(res.getResponseMsg());
        });

        root = btn;
    }

}
