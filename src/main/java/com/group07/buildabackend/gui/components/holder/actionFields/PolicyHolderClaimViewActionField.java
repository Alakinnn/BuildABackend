package com.group07.buildabackend.gui.components.holder.actionFields;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.claim.btn.*;
import com.group07.buildabackend.gui.components.utils.ActionField;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PolicyHolderClaimViewActionField extends ActionField {
    public PolicyHolderClaimViewActionField(String claimId) {
        super();
        addButton(new EditClaimBtn(claimId).getRoot());
        addButton(new AddClaimInfoBtn(claimId).getRoot());
    }
}
