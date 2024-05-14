package com.group07.buildabackend.gui.components.surveyor;

import com.group07.buildabackend.gui.components.user.buttons.EditUserButton;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class InsuranceSurveyorMyProfileActionField extends ActionField {
    public InsuranceSurveyorMyProfileActionField(String userId) {
        super();
        addButton(new EditUserButton(userId).getRoot());
    }
}
