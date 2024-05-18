package com.group07.buildabackend.gui.pages.user;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.user.UserProfile;
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
        Page page = new HeaderDecorator(new Page(root), "Profile");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
