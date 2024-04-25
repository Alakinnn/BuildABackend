package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class NavPage extends Page {
    // A NavPage is a page with a Navigation Bar (NavBar)
    // Decorator for Page

    private Page page;
    public NavPage() {
        super();
    }

    public NavPage(Page page) {
        this.page = page;
    }

    @Override
    public Node getRoot() throws IOException {
        // Load FXML
        Node navPageRoot = FXMLLoader.load(getClass().getResource("NavPage.fxml"));
        Node navBarRoot = FXMLLoader.load(NavBar.class.getResource("NavBar.fxml"));

        // Add the roots to the layout
        HBox navContainer = (HBox) navPageRoot.lookup("#navContainer");
        navContainer.getChildren().add(navBarRoot);
        navContainer.getChildren().add(page.getRoot());

        return navPageRoot;
    }

}
