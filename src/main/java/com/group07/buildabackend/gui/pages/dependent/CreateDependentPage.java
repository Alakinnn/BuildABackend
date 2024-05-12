package com.group07.buildabackend.gui.pages.dependent;

import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class CreateDependentPage extends Page {
    private String phId;

    public CreateDependentPage() {
    }

    public CreateDependentPage(String phId) {
        this.phId = phId;
    }

    @Override
    public Node getRoot() {
        if (phId != null) {
            root = new CreateDependentForm(phId).getRoot();
        } else {
            root = new CreateDependentForm().getRoot();
        }

        Page page = new NavDecorator(new Page(root));
        return page.getRoot();
    }
}
