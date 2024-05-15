package com.group07.buildabackend.gui.pages.admin;

import com.group07.buildabackend.gui.components.admin.SystemAdminUserListView;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class SystemAdminUsersPage extends Page {
    @Override
    public Node getRoot() {
        root = new SystemAdminUserListView().getRoot();
        Page page = new HeaderDecorator(new Page(root), "Users");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
