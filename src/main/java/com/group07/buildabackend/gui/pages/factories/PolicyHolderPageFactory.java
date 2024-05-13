package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimViewPage;

public class PolicyHolderPageFactory implements PageFactory{
    @Override
    public Page createClaimViewPage(String claimId) {
        return new PolicyHolderClaimViewPage(claimId);
    }
}
