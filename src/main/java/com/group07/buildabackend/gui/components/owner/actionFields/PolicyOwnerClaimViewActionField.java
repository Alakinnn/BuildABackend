package com.group07.buildabackend.gui.components.owner.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.claim.btn.AddClaimInfoBtn;
import com.group07.buildabackend.gui.components.claim.btn.DeleteClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.EditClaimBtn;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class PolicyOwnerClaimViewActionField extends ActionField {
    public PolicyOwnerClaimViewActionField(String claimId) {
        super();
        addButton(new EditClaimBtn(claimId).getRoot());
        addButton(new DeleteClaimBtn(claimId).getRoot());
        addButton(new AddClaimInfoBtn(claimId).getRoot());
    }
}
