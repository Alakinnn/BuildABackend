package com.group07.buildabackend.gui.components.claim.btn;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.claim.EditClaimPage;
import javafx.scene.control.Button;

public class EditClaimBtn extends Component {
    public EditClaimBtn(String claimId) {
        Button btn = new Button();
        btn.setText("Edit");
        btn.setOnAction(event -> {
            Page page = new EditClaimPage(claimId);
            SceneManager.getInstance().switchToPage(page);
        });
        root = btn;
    }
}
