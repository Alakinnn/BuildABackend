package com.group07.buildabackend.gui.components.nav.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.auth.LoginPage;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.owner.*;

public class PolicyOwnerNavBarFactory implements NavBarFactory {
    @Override
    public NavBar createNavBar() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        NavBar navBar = new NavBar();

        navBar.addNavLink(new PolicyOwnerBeneficiariesPage(user.getUserId()), "My Beneficiaries");
        navBar.addNavLink(new PolicyOwnerClaimsPage(user.getUserId()), "Beneficiary Claims");
        navBar.addNavLink(new PolicyOwnerCreateClaimPage(user.getUserId()), "File New Claim");
        navBar.addNavLink(new PolicyOwnerCreateHolderPage(user.getUserId()), "Add Policy Holder");
        navBar.addNavLink(new PolicyOwnerCreateDependentPage(user.getUserId()), "Add Dependent");
        navBar.addNavLink(PageFactoryManager.getFactory().createMyProfilePage(), "My Profile");
        navBar.addNavLink(new LoginPage(), "Logout");
        return navBar;
    }
}
