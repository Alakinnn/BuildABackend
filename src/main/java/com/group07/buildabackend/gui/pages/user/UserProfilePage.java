package com.group07.buildabackend.gui.pages.user;

import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class UserProfilePage extends Page {
    private String userId;

    public UserProfilePage(String userId) {
        this.userId = userId;
    }

    @Override
    public Node getRoot() {
        root = new UserProfile(userId).getRoot();
        Page page = new NavDecorator(new Page(root));
        return page.getRoot();
    }
}
