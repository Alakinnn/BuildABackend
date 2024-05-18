package com.group07.buildabackend.gui.components.surveyor.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.claim.btn.ProposeClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.RequestClaimInfoBtn;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class SurveyorClaimViewActionField extends ActionField {

    public SurveyorClaimViewActionField(String claimId) {
        super();
        addButton(new RequestClaimInfoBtn(claimId).getRoot());
        addButton(new ProposeClaimBtn(claimId).getRoot());
    }

}
