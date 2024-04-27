package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class NavBar extends VBox {
    private Parent root;
    public NavBar() {
        try {
            FXMLLoader loader = new FXMLLoader(NavBar.class.getResource("NavBar.fxml"));
//            loader.setRoot(this);
//            loader.setController(new NavBarController());

            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Parent getRoot() {
        return root;
    }
}
