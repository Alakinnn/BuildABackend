package com.group07.buildabackend.gui.components.nav.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.auth.LoginPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderCreateClaimPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderCreateDependentPage;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderDependentsPage;

public class PolicyHolderNavBarFactory implements NavBarFactory{
    @Override
    public NavBar createNavBar() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        String userId = user.getUserId();
        NavBar navBar = new NavBar();

        navBar.addNavLink(new PolicyHolderClaimsPage(userId), "My Claims");
        navBar.addNavLink(new PolicyHolderCreateClaimPage(userId), "File New Claim");
        navBar.addNavLink(new PolicyHolderDependentsPage(userId), "My Dependents");
        navBar.addNavLink(new PolicyHolderCreateDependentPage(userId), "Add Dependent");
        navBar.addNavLink(PageFactoryManager.getFactory().createMyProfilePage(), "My Profile");
        navBar.addNavLink(new LoginPage(), "Logout");
        return navBar;
    }
}
