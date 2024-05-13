package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyHolderDependentsPage extends Page {

    private String phId;

    public PolicyHolderDependentsPage(String phId) {
        this.phId = phId;
    }

    @Override
    public Node getRoot() {
        root = new PolicyHolderDependentList(phId).getRoot();
        Page page = new NavDecorator(new Page(root));
        return page.getRoot();
    }
}
