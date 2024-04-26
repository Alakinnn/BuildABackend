package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.io.IOException;

public class NavDecorator extends Page {
    // Renders a page with a Navigation Bar (NavBar)
    // Decorator for Page

    private Page page;
    public NavDecorator() {
        super();
    }

    public NavDecorator(Page page) {
        this.page = page;
    }

    @Override
    public Node getRoot() throws IOException {
        // Load FXML
        Node navBarRoot = FXMLLoader.load(NavBar.class.getResource("NavBar.fxml"));

        Node pageRoot = page.getRoot();

        // Add the roots to the layout
        HBox navContainer = new HBox();
        navContainer.getChildren().add(navBarRoot);
        navContainer.getChildren().add(pageRoot);

        // Make the page responsive
        HBox.setHgrow(navBarRoot, Priority.NEVER);
        HBox.setHgrow(pageRoot, Priority.ALWAYS);

        return navContainer;
    }

}
