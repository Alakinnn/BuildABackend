package com.group07.buildabackend.gui.components.nav.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import com.group07.buildabackend.gui.pages.claim.PolicyHolderCreateClaimPage;
import com.group07.buildabackend.gui.pages.dependent.CreateDependentPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderDependentsPage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

public class PolicyHolderNavBarFactory implements NavBarFactory{
    @Override
    public NavBar createNavBar() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        String userId = user.getUserId();
        NavBar navBar = new NavBar();

        navBar.addNavLink(new PolicyHolderClaimsPage(userId), "My Claims");
        navBar.addNavLink(new PolicyHolderCreateClaimPage(userId), "File New Claim");
        navBar.addNavLink(new PolicyHolderDependentsPage(userId), "My Dependents");
        navBar.addNavLink(new CreateDependentPage(userId), "Add Dependent");
        navBar.addNavLink(new UserProfilePage(userId), "My Profile");
        return navBar;
    }
}
