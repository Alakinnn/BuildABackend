package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimViewPage;
import com.group07.buildabackend.gui.pages.owner.PolicyOwnerClaimViewPage;

public class PolicyOwnerPageFactory implements PageFactory{
    @Override
    public Page createClaimViewPage(String claimId) {
        return new PolicyOwnerClaimViewPage(claimId);
    }
}
