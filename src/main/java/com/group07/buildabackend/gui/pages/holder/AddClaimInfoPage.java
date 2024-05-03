package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class AddClaimInfoPage extends Page {
    private String claimId;

    public AddClaimInfoPage(String claimId) {
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        root = new AddClaimInfoForm(claimId).getRoot();

        Page page = new HeaderDecorator(new Page(root), "Add Claim Information");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
