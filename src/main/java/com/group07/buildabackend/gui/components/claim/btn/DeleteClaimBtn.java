package com.group07.buildabackend.gui.components.claim.btn;

import com.group07.buildabackend.gui.components.Component;
import javafx.scene.control.Button;

public class DeleteClaimBtn extends Component {
    public DeleteClaimBtn(String claimId) {
        Button btn = new Button();
        btn.setText("Delete");
        btn.setOnAction(event -> {
            // TODO: delete claim on press
        });
        root = btn;
    }
}
