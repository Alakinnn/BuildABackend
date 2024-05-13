package com.group07.buildabackend.gui.pages.dependent;

import com.group07.buildabackend.gui.components.claim.ClaimView;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class DependentClaimViewPage extends Page {
    private String claimId;

    public DependentClaimViewPage(String claimId) {
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        ClaimView claimView = new ClaimView(claimId);

        Page page = new Page(claimView.getRoot());
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
