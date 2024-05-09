package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class NavBar extends ControlledComponent<NavBarController> {
    public NavBar() {
        super(NavBar.class.getResource("NavBar.fxml"));
    }
}
