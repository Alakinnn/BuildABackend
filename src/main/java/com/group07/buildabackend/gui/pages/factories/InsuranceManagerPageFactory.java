package com.group07.buildabackend.gui.pages.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.manager.InsuranceManagerClaimViewPage;
import com.group07.buildabackend.gui.pages.manager.InsuranceManagerClaimsPage;
import com.group07.buildabackend.gui.pages.manager.InsuranceManagerMyProfilePage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

import java.util.function.Consumer;

public class InsuranceManagerPageFactory extends PageFactory{
    @Override
    public Page createDefaultPage() {
        return new InsuranceManagerClaimsPage();
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new InsuranceManagerClaimViewPage(claimId);
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
