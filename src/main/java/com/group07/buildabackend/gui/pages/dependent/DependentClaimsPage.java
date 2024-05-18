package com.group07.buildabackend.gui.pages.dependent;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.dependent.DependentClaimListView;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class DependentClaimsPage extends Page {
    private String dId;

    public DependentClaimsPage(String dId) {
        this.dId = dId;
    }

    @Override
    public Node getRoot() {
        root = new DependentClaimListView(dId).getRoot();
        Page page = new HeaderDecorator(new Page(root), "Claims");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
