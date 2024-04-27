package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.pages.Page;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class NavLink {
    @FXML
    private Button navButton;
    private Page page;

    public NavLink() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NavLink.fxml"));
            loader.setController(this);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public NavLink(Page page) {
        this.page = page;
    }

    public void onNavButtonClick(ActionEvent event) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.switchRoot((Parent) page.getRoot());
    }

    public Button getNavButton() {
        return navButton;
    }
}
