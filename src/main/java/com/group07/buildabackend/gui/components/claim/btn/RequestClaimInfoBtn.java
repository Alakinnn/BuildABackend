package com.group07.buildabackend.gui.components.claim.btn;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.surveyor.RequestClaimInfoPage;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class RequestClaimInfoBtn extends Component {

    public RequestClaimInfoBtn(String claimId) {
        Button btn = new Button();
        btn.setText("Request Information");
        btn.setOnAction(event -> {
            RequestClaimInfoPage page = new RequestClaimInfoPage(claimId);
            SceneManager.getInstance().switchToPage(page);
        });

        root = btn;
    }

}
