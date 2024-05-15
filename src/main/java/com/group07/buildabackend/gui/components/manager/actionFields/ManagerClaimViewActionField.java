package com.group07.buildabackend.gui.components.manager.actionFields;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.claim.btn.ApproveClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.RejectClaimBtn;
import com.group07.buildabackend.gui.components.utils.ActionField;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ManagerClaimViewActionField extends ActionField {
    public ManagerClaimViewActionField(String claimId) {
        super();
        addButton(new RejectClaimBtn(claimId).getRoot());
        addButton(new ApproveClaimBtn(claimId).getRoot());
    }

}
