package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.manager.InsuranceManagerClaimViewPage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

public class InsuranceManagerPageFactory implements PageFactory{
    @Override
    public Page createDefaultPage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new UserProfilePage(user.getUserId());
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new InsuranceManagerClaimViewPage(claimId);
    }

    @Override
    public Page createMyProfilePage() {
        return null;
    }
}
