package com.group07.buildabackend.gui.pages.auth;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.gui.components.auth.LoginForm;
import com.group07.buildabackend.gui.pages.Page;
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
