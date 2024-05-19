package com.group07.buildabackend.gui.components.nav.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.pages.Page;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class NavLinkController implements ComponentController, Initializable {

    @FXML
    private Button navButton;
    private Page page;

    public NavLinkController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navButton.setFocusTraversable(false);
    }

    public void onNavButtonClick(ActionEvent event) {
        SceneManager.getInstance().switchToPage(page);
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setLabel(String label) {
        navButton.setText(label);
    }


}
