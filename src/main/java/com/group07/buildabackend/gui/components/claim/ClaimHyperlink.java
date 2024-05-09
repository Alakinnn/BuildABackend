package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.surveyor.SurveyorInsuranceClaimPage;
import javafx.scene.control.Hyperlink;

public class ClaimHyperlink extends Component {
    public ClaimHyperlink(InsuranceClaim claim) {
        Hyperlink link = new Hyperlink(claim.getClaimId());
        link.setOnAction(event -> {
            // TODO: change depending user role
            SceneManager.getInstance().switchToPage(new SurveyorInsuranceClaimPage(claim.getClaimId()));
        });

        root = link;
    }
}
