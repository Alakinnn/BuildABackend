package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class SurveyorInsuranceClaimPage extends Page {
    private String claimId;
    public SurveyorInsuranceClaimPage(String claimId) {
        super();
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        root = new SurveyorInsuranceClaimView(claimId).getRoot();

        Page page = new HeaderDecorator(new Page(root), "Surveyor: View claim");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
