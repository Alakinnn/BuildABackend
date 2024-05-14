package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.dependent.DependentClaimViewPage;
import com.group07.buildabackend.gui.pages.dependent.DependentClaimsPage;

public class DependentPageFactory implements PageFactory{
    @Override
    public Page createDefaultPage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new DependentClaimsPage(user.getUserId());
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new DependentClaimViewPage(claimId);
    }
}
