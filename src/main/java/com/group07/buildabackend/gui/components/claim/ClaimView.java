package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.gui.components.ControlledComponent;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ClaimView extends ControlledComponent<ClaimViewController> {
    public ClaimView(String claimId) {
        super(ClaimView.class.getResource("ClaimView.fxml"));
        controller.initPage(claimId);
    }

    public ClaimView(String claimId, Node actionField) {
        super(ClaimView.class.getResource("ClaimView.fxml"));
        controller.setActionField(actionField);
        controller.initPage(claimId);
    }
}