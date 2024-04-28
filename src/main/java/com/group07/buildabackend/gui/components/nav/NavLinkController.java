package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.pages.Page;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class NavLinkController implements ComponentController {

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
