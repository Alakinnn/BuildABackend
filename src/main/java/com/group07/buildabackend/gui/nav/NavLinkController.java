package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.pages.Page;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavLinkController {

    @FXML
    private Button navButton;
    private Page page;

    public NavLinkController() {
    }


    public void onNavButtonClick(ActionEvent event) {
        Scene scene = new Scene((Parent) page.getRoot());

        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.switchToScene(scene);
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
