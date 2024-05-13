package com.group07.buildabackend.gui.components.holder;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.claim.btn.*;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PolicyHolderClaimViewActionField extends Component {
    public PolicyHolderClaimViewActionField(String claimId) {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(20);
        hbox.getChildren().add(new EditClaimBtn(claimId).getRoot());
        hbox.getChildren().add(new DeleteClaimBtn(claimId).getRoot());
        hbox.getChildren().add(new AddClaimInfoBtn(claimId).getRoot());
        root = hbox;
    }
}
