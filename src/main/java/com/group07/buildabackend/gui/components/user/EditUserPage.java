package com.group07.buildabackend.gui.components.user;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class EditUserPage extends Page {
    private String userId;

    public EditUserPage(String userId) {
        this.userId = userId;
    }

    @Override
    public Node getRoot() {
        root = new EditUserForm(userId).getRoot();
        Page page = new HeaderDecorator(new Page(root), "Edit User");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
