package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.backend.controller.PolicyHolderController;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.pages.Page;

public class NavLink extends ControlledComponent<NavLinkController> {

    public NavLink(Page page, String label) {
        super(NavLink.class.getResource("NavLink.fxml"));
        controller.setPage(page);
        controller.setLabel(label);
    }
}
