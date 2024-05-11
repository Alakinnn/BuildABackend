package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class CreatePolicyHolderPage extends Page {
    @Override
    public Node getRoot() {
        root = new CreatePolicyHolderForm().getRoot();
        Page page = new NavDecorator(new Page(root));
        return page.getRoot();
    }
}
