package com.group07.buildabackend.gui.components.surveyor;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.claim.btn.ProposeClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.RequestClaimInfoBtn;
import com.group07.buildabackend.gui.components.utils.ActionField;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class SurveyorClaimViewActionField extends ActionField {

    public SurveyorClaimViewActionField(String claimId) {
        super();
        addButton(new RequestClaimInfoBtn(claimId).getRoot());
        addButton(new ProposeClaimBtn(claimId).getRoot());
    }

}
