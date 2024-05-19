package com.group07.buildabackend.gui.pages.admin;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.admin.SystemAdminCreateHolderForm;
import com.group07.buildabackend.gui.components.admin.controllers.SystemAdminCreateHolderFormController;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class SystemAdminCreateHolderPage extends Page {

    @Override
    public Node getRoot() {
        root = new SystemAdminCreateHolderForm().getRoot();

        Page page = new HeaderDecorator(new Page(root), "Create Policy Holder");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
