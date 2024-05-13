package com.group07.buildabackend.gui.components.nav.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.claim.PolicyHolderCreateClaimPage;
import com.group07.buildabackend.gui.pages.dependent.CreateDependentPage;
import com.group07.buildabackend.gui.pages.dependent.DependentClaimsPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

public class DependentNavBarFactory implements NavBarFactory{
    @Override
    public NavBar createNavBar() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        NavBar navBar = new NavBar();

        navBar.addNavLink(new DependentClaimsPage(user.getUserId()), "My Claims");
        navBar.addNavLink(new UserProfilePage(user.getUserId()), "My Profile");
        return navBar;
    }
}
