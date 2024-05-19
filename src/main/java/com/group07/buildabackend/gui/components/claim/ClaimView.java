package com.group07.buildabackend.gui.components.claim;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.claim.controllers.ClaimViewController;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class ClaimView extends ControlledComponent<ClaimViewController> {
    public ClaimView(String claimId) {
        super(ClaimView.class.getResource("ClaimView.fxml"));
        controller.initPage(claimId);
    }

    public ClaimView(String claimId, ActionField actionField) {
        super(ClaimView.class.getResource("ClaimView.fxml"));
        controller.setActionField(actionField);
        controller.initPage(claimId);
    }
}
