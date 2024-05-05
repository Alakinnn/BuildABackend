package com.group07.buildabackend.gui.pages;

import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class Page {
    // Each Page contains a root Node, which specifies how the page should be drawn.
    // This class is mainly used for layouts. If you want to add functionality, consider using Component instead.
    // Override the getRoot() method to customize layout for each Page

    protected Node root;
    public Page() {
    }

    public Page(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}
