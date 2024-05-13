package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.dependent.DependentClaimViewPage;

public class DependentPageFactory implements PageFactory{
    @Override
    public Page createClaimViewPage(String claimId) {
        return new DependentClaimViewPage(claimId);
    }
}
