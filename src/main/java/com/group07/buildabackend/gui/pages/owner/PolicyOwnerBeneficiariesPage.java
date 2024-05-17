package com.group07.buildabackend.gui.pages.owner;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.owner.PolicyOwnerBeneficiaryListView;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyOwnerBeneficiariesPage extends Page {
    private String poId;

    public PolicyOwnerBeneficiariesPage(String poId) {
        this.poId = poId;
    }

    @Override
    public Node getRoot() {
        root = new PolicyOwnerBeneficiaryListView(poId).getRoot();

        Page page = new HeaderDecorator(new Page(root), "My Beneficiaries");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
