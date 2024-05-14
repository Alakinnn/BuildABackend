package com.group07.buildabackend.gui.pages.manager;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.manager.InsuranceManagerMyProfileActionField;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.user.UserProfile;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;
import javafx.scene.Node;

public class InsuranceManagerMyProfilePage extends Page {
    @Override
    public Node getRoot() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        ActionField actionField = new InsuranceManagerMyProfileActionField(user.getUserId());
        root = new UserProfile(user.getUserId(), actionField).getRoot();

        Page page = new HeaderDecorator(new Page(root), "My Profile");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
