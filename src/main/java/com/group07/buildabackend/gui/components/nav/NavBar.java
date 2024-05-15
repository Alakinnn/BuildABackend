package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.nav.controllers.NavBarController;
import com.group07.buildabackend.gui.pages.Page;

public class NavBar extends ControlledComponent<NavBarController> {
    public NavBar() {
        super(NavBar.class.getResource("NavBar.fxml"));
    }
    public void addNavLink(Page page, String label) {
        controller.addNavLink(page, label);
    }
}
