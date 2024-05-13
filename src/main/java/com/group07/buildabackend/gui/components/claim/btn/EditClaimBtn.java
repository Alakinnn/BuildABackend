package com.group07.buildabackend.gui.components.claim.btn;

import com.group07.buildabackend.gui.components.Component;
import javafx.scene.control.Button;

public class EditClaimBtn extends Component {
    public EditClaimBtn(String claimId) {
        Button btn = new Button();
        btn.setText("Edit");
        btn.setOnAction(event -> {
            // TODO: redirect to edit claim page
        });
        root = btn;
    }
}
