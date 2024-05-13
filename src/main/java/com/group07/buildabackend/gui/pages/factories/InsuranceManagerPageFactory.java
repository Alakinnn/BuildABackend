package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.manager.InsuranceManagerClaimViewPage;

public class InsuranceManagerPageFactory implements PageFactory{
    @Override
    public Page createClaimViewPage(String claimId) {
        return new InsuranceManagerClaimViewPage(claimId);
    }
}
