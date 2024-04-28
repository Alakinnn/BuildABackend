package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class AddClaimInfoPage extends Page {

    @Override
    public Node getRoot() {
        try {
            FXMLLoader loader = new FXMLLoader(AddClaimInfoForm.class.getResource("AddClaimInfoForm.fxml"));
            Parent root = loader.load();

            Page page = new HeaderDecorator(new Page(root), "Add Claim Information");
            page = new NavDecorator(page);
            return page.getRoot();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
