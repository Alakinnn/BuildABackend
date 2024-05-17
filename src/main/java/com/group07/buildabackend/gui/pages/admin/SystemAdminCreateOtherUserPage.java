package com.group07.buildabackend.gui.pages.admin;

import com.group07.buildabackend.gui.components.admin.SystemAdminCreateOtherUserForm;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class SystemAdminCreateOtherUserPage extends Page {
    @Override
    public Node getRoot() {
        root = new SystemAdminCreateOtherUserForm().getRoot();

        Page page = new HeaderDecorator(new Page(root), "Create User");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
