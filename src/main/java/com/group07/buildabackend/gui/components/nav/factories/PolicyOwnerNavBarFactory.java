package com.group07.buildabackend.gui.components.nav.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.claim.PolicyHolderCreateClaimPage;
import com.group07.buildabackend.gui.pages.dependent.CreateDependentPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.owner.PolicyOwnerClaimsPage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

public class PolicyOwnerNavBarFactory implements NavBarFactory {
    @Override
    public NavBar createNavBar() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        NavBar navBar = new NavBar();

        navBar.addNavLink(new PolicyOwnerClaimsPage(user.getUserId()), "Claims");
        navBar.addNavLink(new PolicyHolderCreateClaimPage(user.getUserId()), "File New Claim");
        navBar.addNavLink(new CreateDependentPage(user.getUserId()), "Add Dependent");
        navBar.addNavLink(new UserProfilePage(user.getUserId()), "Profile");
        return navBar;
    }
}
