package com.group07.buildabackend.gui.components;

/**
 * @author Group_7
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;

public abstract class ControlledComponent<T extends ComponentController> extends Component{
    // A ControlledComponent is any component in the UI with a controller class.
    // T is the type of the controller
    // T must implement the ComponentController interface.

    protected URL fxmlURL;
    protected T controller;

    public ControlledComponent() {
    }

    public ControlledComponent(URL fxmlURL) {
        try {
            this.fxmlURL = fxmlURL;
            FXMLLoader loader = new FXMLLoader(fxmlURL);
            root = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T getController() {
        return controller;
    }
}
