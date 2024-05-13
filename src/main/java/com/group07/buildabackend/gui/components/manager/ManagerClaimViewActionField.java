package com.group07.buildabackend.gui.components.manager;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.claim.btn.ApproveClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.RejectClaimBtn;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ManagerClaimViewActionField extends Component {
    public ManagerClaimViewActionField(String claimId) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setSpacing(20);
        hBox.getChildren().add(new RejectClaimBtn(claimId).getRoot());
        hBox.getChildren().add(new ApproveClaimBtn(claimId).getRoot());

        root = hBox;
    }

}
