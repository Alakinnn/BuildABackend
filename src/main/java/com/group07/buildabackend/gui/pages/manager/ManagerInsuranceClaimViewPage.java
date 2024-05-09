package com.group07.buildabackend.gui.pages.manager;

import com.group07.buildabackend.gui.components.claim.ClaimView;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.manager.ManagerClaimViewActionField;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.claim.CreateClaimForm;
import javafx.scene.Node;

public class ManagerInsuranceClaimViewPage extends Page {
    private String claimId;
    public ManagerInsuranceClaimViewPage(String claimId) {
        super();
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        ClaimView claimView = new ClaimView(claimId, new ManagerClaimViewActionField(claimId).getRoot());
        Page page = new HeaderDecorator(new Page(claimView.getRoot()), "Manager: View a claim");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
