package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimViewPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.owner.PolicyOwnerClaimViewPage;
import com.group07.buildabackend.gui.pages.owner.PolicyOwnerClaimsPage;

public class PolicyOwnerPageFactory implements PageFactory{
    @Override
    public Page createDefaultPage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new PolicyOwnerClaimsPage(user.getUserId());
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new PolicyOwnerClaimViewPage(claimId);
    }
}
