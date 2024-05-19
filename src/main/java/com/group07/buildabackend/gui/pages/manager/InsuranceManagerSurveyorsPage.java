package com.group07.buildabackend.gui.pages.manager;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.manager.InsuranceManagerSurveyorListView;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class InsuranceManagerSurveyorsPage extends Page {
    @Override
    public Node getRoot() {
        root = new InsuranceManagerSurveyorListView().getRoot();
        Page page = new HeaderDecorator(new Page(root), "Insurance Surveyors");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
