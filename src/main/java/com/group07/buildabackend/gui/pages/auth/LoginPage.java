package com.group07.buildabackend.gui.pages.auth;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.gui.components.nav.factories.NavBarFactoryManager;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.factories.PageFactory;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import javafx.scene.Node;

public class LoginPage extends Page {

    @Override
    public Node getRoot() {
        // Crude logout implementation
        if (CurrentUserManager.getCurrentUser() != null) {
            CurrentUserManager.setCurrentUser(null);
        }

        root = new LoginForm().getRoot();
        return root;
    }
}
