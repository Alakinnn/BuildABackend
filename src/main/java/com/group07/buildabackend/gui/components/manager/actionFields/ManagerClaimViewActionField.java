package com.group07.buildabackend.gui.components.manager.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.claim.btn.ApproveClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.RejectClaimBtn;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class ManagerClaimViewActionField extends ActionField {
    public ManagerClaimViewActionField(String claimId) {
        super();
        addButton(new RejectClaimBtn(claimId).getRoot());
        addButton(new ApproveClaimBtn(claimId).getRoot());
    }

}
