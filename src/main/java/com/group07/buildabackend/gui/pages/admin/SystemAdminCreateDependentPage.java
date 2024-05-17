package com.group07.buildabackend.gui.pages.admin;

import com.group07.buildabackend.gui.components.admin.SystemAdminCreateDependentForm;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class SystemAdminCreateDependentPage extends Page {
    @Override
    public Node getRoot() {
        root = new SystemAdminCreateDependentForm().getRoot();

        Page page = new HeaderDecorator(new Page(root), "Create Dependent");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
