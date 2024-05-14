package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;
import javafx.scene.control.Hyperlink;

public class UserHyperlink extends Component {
    public UserHyperlink(SystemUser user) {
        Hyperlink link = new Hyperlink(user.getFullName() + " (" + user.getUserId() + ")");
        link.setOnAction(event -> {
            Page page;
            SystemUser currentUser = CurrentUserManager.getCurrentUser();

            if (user.getUserId().equals(currentUser.getUserId())) {
                page =  PageFactoryManager.getFactory().createMyProfilePage();
            } else {
                page = new UserProfilePage(user.getUserId());
            }


            SceneManager.getInstance().switchToPage(page);
        });

        root = link;
    }
}
