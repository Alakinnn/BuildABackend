package com.group07.buildabackend.gui.components.manager;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.manager.controllers.InsuranceManagerSurveyorListViewController;

public class InsuranceManagerSurveyorListView extends ControlledComponent<InsuranceManagerSurveyorListViewController> {
    public InsuranceManagerSurveyorListView() {
        super(InsuranceManagerSurveyorListView.class.getResource("InsuranceManagerSurveyorListView.fxml"));
    }
}
