package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.Component;
import javafx.scene.control.Hyperlink;

public class UserHyperlink extends Component {
    public UserHyperlink(SystemUser user) {
        Hyperlink link = new Hyperlink(user.getFullName() + " (" + user.getUserId() + ")");
        link.setOnAction(event -> {
            // TODO: redirect to profile page
        });

        root = link;
    }
}
