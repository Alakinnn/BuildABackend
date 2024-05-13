package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class NavBarController implements ComponentController {
    @FXML
    private VBox navBox;

    public void addNavLink(Page page, String label) {
        navBox.getChildren().add(new NavLink(page, label).getRoot());
    }

}
