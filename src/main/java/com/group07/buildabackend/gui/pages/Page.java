package com.group07.buildabackend.gui.pages;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.Component;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class Page extends Component {
    // Each Page contains a root Node, which specifies how the page should be drawn.
    // This class is mainly used for layouts. If you want to add functionality, consider using Component instead.
    // Override the getRoot() method to customize layout for each Page


    public Page() {
        super();
    }

    public Page(Node root) {
        super(root);
    }
}
