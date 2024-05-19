package com.group07.buildabackend.gui.components.nav;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.nav.factories.NavBarFactoryManager;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;
import javafx.scene.layout.*;

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
    public Node getRoot() {
        // Load FXML
        NavBar navBar = NavBarFactoryManager.getFactory().createNavBar();

        Node pageRoot = page.getRoot();

        // Add the roots to the layout
        HBox navContainer = new HBox();
        navContainer.getChildren().add(navBar.getRoot());
        navContainer.getChildren().add(pageRoot);

        // Make the page responsive
        HBox.setHgrow(navBar.getRoot(), Priority.NEVER);
        HBox.setHgrow(pageRoot, Priority.ALWAYS);

        return navContainer;
    }

}
