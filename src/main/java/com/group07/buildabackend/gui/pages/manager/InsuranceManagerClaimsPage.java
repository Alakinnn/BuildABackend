package com.group07.buildabackend.gui.pages.manager;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.manager.InsuranceManagerClaimListView;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class InsuranceManagerClaimsPage extends Page {
    @Override
    public Node getRoot() {
        root = new InsuranceManagerClaimListView().getRoot();
        Page page = new HeaderDecorator(new Page(root), "Claims");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
