package com.group07.buildabackend.gui.components.holder;

import com.group07.buildabackend.gui.components.claim.ClaimView;
import com.group07.buildabackend.gui.components.holder.actionFields.PolicyHolderClaimViewActionField;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyHolderClaimViewPage extends Page {
    private String claimId;

    public PolicyHolderClaimViewPage(String claimId) {
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        ActionField actionField = new PolicyHolderClaimViewActionField(claimId);
        ClaimView claimView = new ClaimView(claimId, actionField);

        Page page = new Page(claimView.getRoot());
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
