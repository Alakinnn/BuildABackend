package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import com.group07.buildabackend.gui.pages.holder.AddClaimInfoPage;
import com.group07.buildabackend.gui.pages.manager.ManagerInsuranceClaimViewPage;
import com.group07.buildabackend.gui.pages.surveyor.RequestClaimInfoPage;
import com.group07.buildabackend.gui.pages.surveyor.SurveyorInsuranceClaimPage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NavBarController implements Initializable, ComponentController {
    @FXML
    private VBox navBox;

    private List<Node> navLinks;

    public NavBarController() {
        navLinks = new ArrayList<>();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navBox.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        addNavLink(new CreateClaimPage(), "Create Claim");
        addNavLink(new RequestClaimInfoPage("123456"), "Request Claim Info");
        addNavLink(new AddClaimInfoPage("123456"), "Add Claim Info");
        addNavLink(new ManagerInsuranceClaimViewPage(), "Manager: View Claim");
        addNavLink(new SurveyorInsuranceClaimPage(), "Surveyor: View Claim");

        navBox.getChildren().addAll(navLinks);
    }

    private void addNavLink(Page page, String label) {
        navLinks.add(new NavLink(page, label).getRoot());
    }

}