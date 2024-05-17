package com.group07.buildabackend.gui.pages.owner;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.owner.PolicyOwnerCreateDependentForm;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyOwnerCreateDependentPage extends Page {
    private String poId;

    public PolicyOwnerCreateDependentPage(String poId) {
        this.poId = poId;
    }

    @Override
    public Node getRoot() {
        root = new PolicyOwnerCreateDependentForm(poId).getRoot();
        Page page = new HeaderDecorator(new Page(root), "Add Dependent");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
