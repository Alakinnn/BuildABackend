package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.components.Component;

public class SurveyorInsuranceClaimView extends Component<SurveyorInsuranceClaimViewController> {
    public SurveyorInsuranceClaimView(String claimId) {
        super(SurveyorInsuranceClaimView.class.getResource("SurveyorInsuranceClaimView.fxml"));
        controller.setClaimId(claimId);
    }
}
