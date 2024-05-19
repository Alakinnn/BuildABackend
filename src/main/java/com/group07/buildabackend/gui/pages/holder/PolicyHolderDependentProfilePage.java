package com.group07.buildabackend.gui.pages.holder;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.holder.actionFields.PolicyHolderDependentProfileActionField;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.user.UserProfile;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyHolderDependentProfilePage extends Page {
    private String targetUserId;

    public PolicyHolderDependentProfilePage(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    @Override
    public Node getRoot() {
        ActionField actionField = new PolicyHolderDependentProfileActionField(targetUserId);
        root = new UserProfile(targetUserId, actionField).getRoot();

        Page page = new HeaderDecorator(new Page(root), "User Profile");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
