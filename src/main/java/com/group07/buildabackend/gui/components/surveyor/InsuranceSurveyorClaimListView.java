package com.group07.buildabackend.gui.components.surveyor;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.surveyor.controllers.InsuranceSurveyorClaimListViewController;

public class InsuranceSurveyorClaimListView extends ControlledComponent<InsuranceSurveyorClaimListViewController> {
    public InsuranceSurveyorClaimListView() {
        super(InsuranceSurveyorClaimListView.class.getResource("InsuranceSurveyorClaimListView.fxml"));
    }
}
