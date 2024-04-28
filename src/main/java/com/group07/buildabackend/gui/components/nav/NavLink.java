package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NavLink extends Component {
    private Page page;

    public NavLink(Page page) {
        super(NavLink.class.getResource("NavLink.fxml"));
        ((NavLinkController) controller).setPage(page);
    }
}
