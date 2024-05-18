package com.group07.buildabackend.gui.components.holder.actionFields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.claim.btn.*;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class PolicyHolderClaimViewActionField extends ActionField {
    public PolicyHolderClaimViewActionField(String claimId) {
        super();
        addButton(new EditClaimBtn(claimId).getRoot());
        addButton(new AddClaimInfoBtn(claimId).getRoot());
    }
}
