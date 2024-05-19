package com.group07.buildabackend.gui.pages.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.surveyor.InsuranceSurveyorClaimViewPage;
import com.group07.buildabackend.gui.pages.surveyor.InsuranceSurveyorClaimsPage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

import java.util.function.Consumer;

public class InsuranceSurveyorPageFactory extends PageFactory{

    @Override
    public Page createDefaultPage() {
        return new InsuranceSurveyorClaimsPage();
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new InsuranceSurveyorClaimViewPage(claimId);
    }

    @Override
    public Page createMyProfilePage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new UserProfilePage(user.getUserId());
    }

    @Override
    public void createPublicProfilePage(String targetUserId, Consumer<Page> onSuccess) {
        Page page = new UserProfilePage(targetUserId);
        onSuccess.accept(page);
    }
}
