package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class NavBar extends VBox {
    // TODO: should create a Component class that has root and getRoot
    private Parent root;
    public NavBar() {
        try {
            FXMLLoader loader = new FXMLLoader(NavBar.class.getResource("NavBar.fxml"));
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Parent getRoot() {
        return root;
    }
}
