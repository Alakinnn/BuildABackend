package com.group07.buildabackend.gui.components.surveyor;

import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.claim.btn.ProposeClaimBtn;
import com.group07.buildabackend.gui.components.claim.btn.RequestClaimInfoBtn;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class SurveyorClaimViewActionField extends Component {

    public SurveyorClaimViewActionField(String claimId) {
        HBox hbox = new HBox();
        hbox.getChildren().add(new RequestClaimInfoBtn(claimId).getRoot());
        hbox.getChildren().add(new ProposeClaimBtn(claimId).getRoot());

        root = hbox;
    }

}
