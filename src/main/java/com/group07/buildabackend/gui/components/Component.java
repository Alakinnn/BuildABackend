package com.group07.buildabackend.gui.components;

import com.group07.buildabackend.gui.components.upload.ComponentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;

public abstract class Component {
    // A Component is any component in the UI with a controller (e.g. buttons, file uploads, navbar).
    // Note that although this class also has a reference to root, it is distinctly different from page in that it has a corresponding controller.
    // Child classes need to provide an FXML URL to the constructor to load in the corresponding FXML resource.
    // Alternatively, use the empty constructor and create your own component programmatically (without FXML)

    protected Node root;
    protected URL fxmlURL;
    protected ComponentController controller;

    public Component() {
    }

    public Component(URL fxmlURL) {
        try {
            this.fxmlURL = fxmlURL;
            FXMLLoader loader = new FXMLLoader(fxmlURL);
            root = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Node getRoot() {
        return root;
    };
}
