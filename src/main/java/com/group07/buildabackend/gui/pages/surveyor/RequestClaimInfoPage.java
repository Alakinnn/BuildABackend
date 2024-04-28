package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.header.HeaderDecorator;
import com.group07.buildabackend.gui.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class RequestClaimInfoPage extends Page {
    @Override
    public Node getRoot() {
        try {
            FXMLLoader loader = new FXMLLoader(RequestClaimInfoForm.class.getResource("RequestClaimInfoForm.fxml"));
            Parent root = loader.load();

            Page page = new HeaderDecorator(new Page(root), "Request Claim Information");
            page = new NavDecorator(page);

            return page.getRoot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
