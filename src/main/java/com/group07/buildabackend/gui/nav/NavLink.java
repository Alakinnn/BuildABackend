package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.pages.Page;
import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NavLink extends AnchorPane {
    private Parent root;
    private Page page;

    public NavLink(@NamedArg("page") Page page) {
        try {
            FXMLLoader loader = new FXMLLoader(NavLink.class.getResource("NavLink.fxml"));

            root = loader.load();
            NavLinkController controller = loader.getController();
            controller.setPage(page);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Parent getRoot() {
        return root;
    }
}
