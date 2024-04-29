package com.group07.buildabackend.gui.pages.manager;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.claim.CreateClaimForm;
import javafx.scene.Node;

public class ManagerInsuranceClaimViewPage extends Page {
    public ManagerInsuranceClaimViewPage() {
        super();
    }

    @Override
    public Node getRoot() {

        root = new ManagerInsuranceClaimView().getRoot();
        Page page = new HeaderDecorator(new Page(root), "Manager: View a claim");
        page = new NavDecorator(page);

        return page.getRoot();


    }
}
