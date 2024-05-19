package com.group07.buildabackend.gui.pages.holder;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.holder.PolicyHolderCreateDependentForm;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyHolderCreateDependentPage extends Page {
    private String phId;

    public PolicyHolderCreateDependentPage(String phId) {
        this.phId = phId;
    }

    @Override
    public Node getRoot() {
        root = new PolicyHolderCreateDependentForm(phId).getRoot();

        Page page = new NavDecorator(new Page(root));
        return page.getRoot();
    }
}
