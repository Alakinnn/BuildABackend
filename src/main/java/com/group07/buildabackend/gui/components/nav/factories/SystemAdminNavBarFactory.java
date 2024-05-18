package com.group07.buildabackend.gui.components.nav.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.admin.*;
import com.group07.buildabackend.gui.pages.auth.LoginPage;
import com.group07.buildabackend.gui.pages.dependent.DependentClaimsPage;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

public class SystemAdminNavBarFactory implements NavBarFactory{
    @Override
    public NavBar createNavBar() {
        NavBar navBar = new NavBar();

        navBar.addNavLink(new SystemAdminUsersPage(), "Users");
        navBar.addNavLink(new SystemAdminClaimsPage(), "Claims");
        navBar.addNavLink(new SystemAdminCreateDependentPage(), "Create Dependent");
        navBar.addNavLink(new SystemAdminCreateHolderPage(), "Create Policy Holder");
        navBar.addNavLink(new SystemAdminCreateOwnerPage(), "Create Policy Owner");
        navBar.addNavLink(new SystemAdminCreateOtherUserPage(), "Create Other Users");
        navBar.addNavLink(PageFactoryManager.getFactory().createMyProfilePage(), "My Profile");
        navBar.addNavLink(new LoginPage(), "Logout");
        return navBar;

    }
}
