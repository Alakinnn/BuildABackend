package com.group07.buildabackend.gui.pages.claim;

import com.group07.buildabackend.gui.components.claim.EditClaimForm;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class EditClaimPage extends Page {
    private String claimId;

    public EditClaimPage(String claimId) {
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        root = new EditClaimForm(claimId).getRoot();
        Page page = new NavDecorator(new Page(root));
        return page.getRoot();
    }
}
