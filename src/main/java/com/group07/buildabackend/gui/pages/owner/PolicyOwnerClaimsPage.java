package com.group07.buildabackend.gui.pages.owner;

import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyOwnerClaimsPage extends Page {

    private String policyOwnerId;

    public PolicyOwnerClaimsPage(String policyOwnerId) {
        this.policyOwnerId = policyOwnerId;
    }

    @Override
    public Node getRoot() {
        root = new PolicyOwnerClaimListView(policyOwnerId).getRoot();
        Page page = new NavDecorator(new Page(root));
        return page.getRoot();
    }
}
