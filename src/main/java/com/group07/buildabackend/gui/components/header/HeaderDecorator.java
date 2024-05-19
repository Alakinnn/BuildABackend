package com.group07.buildabackend.gui.components.header;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HeaderDecorator extends Page {
    // Renders a page with a Header
    // Decorator for Page

    private Page page;
    private String title;

    public HeaderDecorator() {
        super();
    }

    public HeaderDecorator(Page page, String title) {
        this.page = page;
        this.title = title;
    }

    @Override
    public Node getRoot() {
        try {
            // Load FXML
            FXMLLoader headerLoader = new FXMLLoader(Header.class.getResource("Header.fxml"));
            Node headerRoot = headerLoader.load();

            // Set header Title
            Header header = headerLoader.getController();
            header.setTitle(title);


            // Add the roots to the layout
            VBox headerContainer = new VBox();
            headerContainer.getChildren().add(headerRoot);
            headerContainer.getChildren().add(page.getRoot());

            return headerContainer;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
