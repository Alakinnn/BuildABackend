package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.holder.PolicyHolderClaimListView;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyHolderClaimsPage extends Page {
    private String phId;
    public PolicyHolderClaimsPage(String phId) {
        this.phId = phId;
    }

    @Override
    public Node getRoot() {
        root = new PolicyHolderClaimListView(phId).getRoot();
        Page page = new HeaderDecorator(new Page(root), "Claims");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
