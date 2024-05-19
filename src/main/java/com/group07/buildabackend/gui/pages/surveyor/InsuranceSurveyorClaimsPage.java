package com.group07.buildabackend.gui.pages.surveyor;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.components.surveyor.InsuranceSurveyorClaimListView;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class InsuranceSurveyorClaimsPage extends Page {

    @Override
    public Node getRoot() {
        root = new InsuranceSurveyorClaimListView().getRoot();
        Page page = new HeaderDecorator(new Page(root), "Claims");
        page = new NavDecorator(page);
        return page.getRoot();
    }
}
