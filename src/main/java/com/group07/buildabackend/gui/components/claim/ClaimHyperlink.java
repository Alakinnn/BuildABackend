package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.factories.PageFactory;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.surveyor.InsuranceSurveyorClaimViewPage;
import javafx.scene.control.Hyperlink;

public class ClaimHyperlink extends Component {
    public ClaimHyperlink(InsuranceClaim claim) {
        String claimId = claim.getClaimId();
        Hyperlink link = new Hyperlink(claimId);
        link.setOnAction(event -> {
            Page page = PageFactoryManager.getFactory().createClaimViewPage(claimId);
            SceneManager.getInstance().switchToPage(page);
        });

        root = link;
    }
}
