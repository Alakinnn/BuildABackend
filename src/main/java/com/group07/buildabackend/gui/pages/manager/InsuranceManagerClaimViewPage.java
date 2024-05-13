package com.group07.buildabackend.gui.pages.manager;

import com.group07.buildabackend.gui.components.claim.ClaimView;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.manager.ManagerClaimViewActionField;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class InsuranceManagerClaimViewPage extends Page {
    private String claimId;
    public InsuranceManagerClaimViewPage(String claimId) {
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
