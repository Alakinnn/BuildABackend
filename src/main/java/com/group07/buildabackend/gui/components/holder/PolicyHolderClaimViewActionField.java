package com.group07.buildabackend.gui.components.holder;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.claim.btn.DeleteClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.EditClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.ProposeClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.RequestClaimInfoBtn;
import javafx.scene.layout.HBox;

public class PolicyHolderClaimViewActionField extends Component {
    public PolicyHolderClaimViewActionField(String claimId) {
        HBox hbox = new HBox();
        hbox.getChildren().add(new EditClaimBtn(claimId).getRoot());
        hbox.getChildren().add(new DeleteClaimBtn(claimId).getRoot());

        root = hbox;
    }
}
