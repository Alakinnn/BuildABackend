package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import javafx.scene.Node;

public class SurveyorInsuranceClaimPage extends Page {
    public SurveyorInsuranceClaimPage() {
        super();
    }

    @Override
    public Node getRoot() {
            root = new SurveyorInsuranceClaimView().getRoot();

        Page page = new HeaderDecorator(new Page(root), "Surveyor: View claim");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
