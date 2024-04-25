package com.group07.buildabackend.gui;

import com.group07.buildabackend.gui.header.HeaderPage;
import com.group07.buildabackend.gui.nav.NavPage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class CreateClaimPage extends Page {
    public CreateClaimPage() throws IOException {
        super();
    }


    @Override
    public Node getRoot() throws IOException {
        Parent root = FXMLLoader.load(CreateClaimPage.class.getResource("CreateClaimForm.fxml"));

        Page page = new HeaderPage(new Page(root), "Create a Claim");
        page = new NavPage(page);

        return page.getRoot();
    }
}
