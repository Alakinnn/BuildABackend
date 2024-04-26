package com.group07.buildabackend.gui.header;

import com.group07.buildabackend.gui.Page;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HeaderPage extends Page {
    // A HeaderPage is a page with a Header (NavBar)
    // Decorator for Page

    private Page page;
    private String title;

    public HeaderPage() {
        super();
    }

    public HeaderPage(Page page, String title) {
        this.page = page;
        this.title = title;
    }

    @Override
    public Node getRoot() throws IOException {
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
    }
}
