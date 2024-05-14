package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.surveyor.InsuranceSurveyorClaimViewPage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

public class InsuranceSurveyorPageFactory implements PageFactory{

    @Override
    public Page createDefaultPage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new UserProfilePage(user.getUserId());
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new InsuranceSurveyorClaimViewPage(claimId);
    }
}
