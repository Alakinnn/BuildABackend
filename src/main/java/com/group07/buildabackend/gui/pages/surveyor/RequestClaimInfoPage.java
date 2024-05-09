package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class RequestClaimInfoPage extends Page {
    private String claimId;

    public RequestClaimInfoPage(String claimId) {
        this.claimId = claimId;
    }

    @Override
    public Node getRoot() {
        root = new RequestClaimInfoForm(claimId).getRoot();

        Page page = new HeaderDecorator(new Page(root), "Request Claim Information");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
