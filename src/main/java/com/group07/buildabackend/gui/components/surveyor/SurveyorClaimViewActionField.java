package com.group07.buildabackend.gui.components.surveyor;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.claim.btn.ProposeClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.RequestClaimInfoBtn;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class SurveyorClaimViewActionField extends Component {

    public SurveyorClaimViewActionField(String claimId) {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(20);
        hbox.getChildren().add(new RequestClaimInfoBtn(claimId).getRoot());
        hbox.getChildren().add(new ProposeClaimBtn(claimId).getRoot());

        root = hbox;
    }

}
