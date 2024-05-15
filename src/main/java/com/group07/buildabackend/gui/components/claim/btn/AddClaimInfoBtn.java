package com.group07.buildabackend.gui.components.claim.btn;

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.holder.AddClaimInfoPage;
import javafx.scene.control.Button;

public class AddClaimInfoBtn extends Component {
    public AddClaimInfoBtn(String claimId) {
        Button btn = new Button();
        btn.setText("Add Information");
        btn.setOnAction(event -> {
            AddClaimInfoPage page = new AddClaimInfoPage(claimId);
            SceneManager.getInstance().switchToPage(page);
        });
        root = btn;
    }
}
