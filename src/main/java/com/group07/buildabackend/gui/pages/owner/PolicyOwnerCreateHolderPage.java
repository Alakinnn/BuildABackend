package com.group07.buildabackend.gui.pages.owner;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.owner.PolicyOwnerCreateHolderForm;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyOwnerCreateHolderPage extends Page {
    private String poId;

    public PolicyOwnerCreateHolderPage(String poId) {
        this.poId = poId;
    }

    @Override
    public Node getRoot() {
        root = new PolicyOwnerCreateHolderForm(poId).getRoot();
        Page page = new HeaderDecorator(new Page(root), "Add Policy Holder");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
