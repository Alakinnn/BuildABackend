package com.group07.buildabackend.gui.pages.owner;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.owner.PolicyOwnerClaimListView;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class PolicyOwnerClaimsPage extends Page {

    private String policyOwnerId;

    public PolicyOwnerClaimsPage(String policyOwnerId) {
        this.policyOwnerId = policyOwnerId;
    }

    @Override
    public Node getRoot() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        root = new PolicyOwnerClaimListView(policyOwnerId).getRoot();
        Page page = new HeaderDecorator(new Page(root), "Beneficiary Claims");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
