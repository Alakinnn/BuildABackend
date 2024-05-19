package com.group07.buildabackend.gui.pages.admin;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.admin.SystemAdminCreateOwnerForm;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class SystemAdminCreateOwnerPage extends Page {
    @Override
    public Node getRoot() {
        root = new SystemAdminCreateOwnerForm().getRoot();

        Page page = new HeaderDecorator(new Page(root), "Create Policy Owner");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
