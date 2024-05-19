package com.group07.buildabackend.gui.pages.claim;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.claim.CreateClaimForm;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class CreateClaimPage extends Page {
    private String phId;
    public CreateClaimPage() {
        super();
    }

    public CreateClaimPage(String phId) {
        this();
        this.phId = phId;
    }

    @Override
    public Node getRoot() {

        root = new CreateClaimForm().getRoot();
        Page page = new HeaderDecorator(new Page(root), "Create a Claim");
        page = new NavDecorator(page);

        return page.getRoot();


    }
}
