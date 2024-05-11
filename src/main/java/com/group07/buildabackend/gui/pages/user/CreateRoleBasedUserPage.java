package com.group07.buildabackend.gui.pages.user;

import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class CreateRoleBasedUserPage extends Page {
    @Override
    public Node getRoot() {
        root = new CreateRoleBasedUserForm().getRoot();
        Page page = new NavDecorator(new Page(root));
        return page.getRoot();
    }
}
