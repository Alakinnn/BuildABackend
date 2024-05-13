package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.surveyor.InsuranceSurveyorClaimViewPage;

public class InsuranceSurveyorPageFactory implements PageFactory{

    @Override
    public Page createClaimViewPage(String claimId) {
        return new InsuranceSurveyorClaimViewPage(claimId);
    }
}
