package com.group07.buildabackend.gui.components.user.buttons;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.components.user.EditUserPage;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.control.Button;

public class EditUserButton extends Component {
    public EditUserButton(String userId) {
        Button btn = new Button();
        btn.setText("Edit");
        btn.setOnAction(event -> {
            Page page = new EditUserPage(userId);
            SceneManager.getInstance().switchToPage(page);
        });

        root = btn;
    }
}
