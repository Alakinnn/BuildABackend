package com.group07.buildabackend.gui.pages.admin;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.admin.actionFields.SystemAdminMyProfileActionField;
import com.group07.buildabackend.gui.components.admin.actionFields.SystemAdminPublicProfileActionField;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.user.UserProfile;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class SystemAdminPublicProfilePage extends Page {
    private String targetUserId;

    public SystemAdminPublicProfilePage(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    @Override
    public Node getRoot() {
        ActionField actionField = new SystemAdminPublicProfileActionField(targetUserId);

        root = new UserProfile(targetUserId, actionField).getRoot();

        Page page = new HeaderDecorator(new Page(root), "User Profile");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
