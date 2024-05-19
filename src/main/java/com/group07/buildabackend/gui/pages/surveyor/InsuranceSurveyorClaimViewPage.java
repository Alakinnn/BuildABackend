package com.group07.buildabackend.gui.pages.surveyor;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.claim.ClaimView;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.surveyor.actionFields.SurveyorClaimViewActionField;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class InsuranceSurveyorClaimViewPage extends Page {
    private String claimId;

    public InsuranceSurveyorClaimViewPage(String claimId) {
        super();
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        ActionField actionField = new SurveyorClaimViewActionField(claimId);
        ClaimView claimView = new ClaimView(claimId, actionField);

        Page page = new HeaderDecorator(new Page(claimView.getRoot()), "Surveyor: View claim");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
