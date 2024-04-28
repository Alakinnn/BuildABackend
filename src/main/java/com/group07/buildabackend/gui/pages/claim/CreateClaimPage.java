package com.group07.buildabackend.gui.pages.claim;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class CreateClaimPage extends Page {
    public CreateClaimPage() {
        super();
    }

    @Override
    public Node getRoot() {
        try {
            FXMLLoader loader = new FXMLLoader(CreateClaimForm.class.getResource("CreateClaimForm.fxml"));
            Parent root = loader.load();

            Page page = new HeaderDecorator(new Page(root), "Create a Claim");
            page = new NavDecorator(page);

            return page.getRoot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
