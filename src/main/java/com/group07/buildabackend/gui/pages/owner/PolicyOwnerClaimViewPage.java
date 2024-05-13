package com.group07.buildabackend.gui.pages.owner;

import com.group07.buildabackend.gui.components.claim.ClaimView;
import com.group07.buildabackend.gui.components.holder.PolicyHolderClaimViewActionField;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyOwnerClaimViewPage extends Page {
    private String claimId;

    public PolicyOwnerClaimViewPage(String claimId) {
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        // Using the same action field as policyholder
        Node actionField = new PolicyHolderClaimViewActionField(claimId).getRoot();
        ClaimView claimView = new ClaimView(claimId, actionField);

        Page page = new Page(claimView.getRoot());
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
