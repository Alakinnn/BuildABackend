package com.group07.buildabackend.gui.components.nav;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.auth.LoginPage;
import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import com.group07.buildabackend.gui.pages.dependent.CreateDependentPage;
import com.group07.buildabackend.gui.pages.dependent.DependentClaimsPage;
import com.group07.buildabackend.gui.pages.holder.AddClaimInfoPage;
import com.group07.buildabackend.gui.pages.holder.CreatePolicyHolderPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.manager.ManagerInsuranceClaimViewPage;
import com.group07.buildabackend.gui.pages.owner.PolicyOwnerClaimsPage;
import com.group07.buildabackend.gui.pages.surveyor.RequestClaimInfoPage;
import com.group07.buildabackend.gui.pages.surveyor.SurveyorInsuranceClaimPage;
import com.group07.buildabackend.gui.pages.user.CreateRoleBasedUserPage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;
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

//    private List<Node> navLinks;

//    public NavBarController() {
//        navLinks = new ArrayList<>();
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navBox.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

//        addNavLink(new CreateClaimPage(), "Create Claim");
//        addNavLink(new RequestClaimInfoPage("c_8e597dc2"), "Request Claim Info");
//        addNavLink(new AddClaimInfoPage("c_8e597dc2"), "Add Claim Info");
//        addNavLink(new ManagerInsuranceClaimViewPage("c_8e597dc2"), "Manager: View Claim");
//        addNavLink(new SurveyorInsuranceClaimPage("c_8e597dc2"), "Surveyor: View Claim");
//        addNavLink(new PolicyHolderClaimsPage("u_7b85436d"), "Claims (PH)");
//        addNavLink(new DependentClaimsPage("u6"), "Claims (Dep)");
//        addNavLink(new PolicyOwnerClaimsPage(), "Claims(PO)");
//        addNavLink(new UserProfilePage("u_7b85436d"), "Profile (PH)");
//        addNavLink(new LoginPage(), "Login");
//        addNavLink(new CreateDependentPage(), "Create Dependent");
//        addNavLink(new CreatePolicyHolderPage(), "Create Policy Holder");
//        addNavLink(new CreateRoleBasedUserPage(), "Create User");
//        navBox.getChildren().addAll(navLinks);
    }

    public void addNavLink(Page page, String label) {
        navBox.getChildren().add(new NavLink(page, label).getRoot());
    }

}
