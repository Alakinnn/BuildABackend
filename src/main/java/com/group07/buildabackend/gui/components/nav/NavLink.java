package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NavLink extends Component {

    public NavLink(Page page, String label) {
        super(NavLink.class.getResource("NavLink.fxml"));
        ((NavLinkController) controller).setPage(page);
        ((NavLinkController) controller).setLabel(label);
    }
}
