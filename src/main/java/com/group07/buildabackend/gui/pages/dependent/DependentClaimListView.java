package com.group07.buildabackend.gui.pages.dependent;

import com.group07.buildabackend.gui.components.Component;

public class DependentClaimListView extends Component<DependentClaimListController> {
    public DependentClaimListView(String dId) {
        super(DependentClaimListView.class.getResource("DependentClaimListView.fxml"));
        controller.innitPage(dId);
    }
}
