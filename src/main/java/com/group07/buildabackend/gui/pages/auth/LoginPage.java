package com.group07.buildabackend.gui.pages.auth;

import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class LoginPage extends Page {
    @Override
    public Node getRoot() {
        root = new LoginForm().getRoot();
        return root;
    }
}
