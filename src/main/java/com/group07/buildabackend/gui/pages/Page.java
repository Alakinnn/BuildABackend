package com.group07.buildabackend.gui.pages;

import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class Page {
    // Each Page contains a root Node, which specifies how the page should be drawn.
    // Override the getRoot() method to customize layout for each Page

    protected Node root;
    public Page() {
    }

    public Page(Node root) {
        this.root = root;
    }

    public Node getRoot() throws IOException {
        return root;
    }
}
