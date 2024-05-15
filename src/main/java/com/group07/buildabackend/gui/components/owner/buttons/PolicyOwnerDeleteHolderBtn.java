package com.group07.buildabackend.gui.components.owner.buttons;

import com.group07.buildabackend.gui.components.Component;
import javafx.scene.control.Button;

public class PolicyOwnerDeleteHolderBtn extends Component {
    public PolicyOwnerDeleteHolderBtn(String userId) {
        Button btn = new Button();
        btn.setText("Delete");
        // TODO: implement BE

        root = btn;
    }
}
