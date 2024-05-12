package com.group07.buildabackend.gui.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;

public class PolicyHolderPageFactory implements PageFactory {
    @Override
    public Page createDefaultPage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new PolicyHolderClaimsPage(user.getUserId());
    }
}
