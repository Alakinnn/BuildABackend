package com.group07.buildabackend.gui.pages.owner;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.owner.actionFields.PolicyOwnerMyProfileActionField;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.components.user.UserProfile;
import javafx.scene.Node;

public class PolicyOwnerMyProfilePage extends Page {
    @Override
    public Node getRoot() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        ActionField actionField = new PolicyOwnerMyProfileActionField(user.getUserId());
        root = new UserProfile(user.getUserId(), actionField).getRoot();

        Page page = new HeaderDecorator(new Page(root), "My Profile");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
