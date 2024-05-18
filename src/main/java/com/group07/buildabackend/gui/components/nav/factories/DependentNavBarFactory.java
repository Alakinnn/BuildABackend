package com.group07.buildabackend.gui.components.nav.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.auth.LoginPage;
import com.group07.buildabackend.gui.pages.dependent.DependentClaimsPage;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;

public class DependentNavBarFactory implements NavBarFactory{
    @Override
    public NavBar createNavBar() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        NavBar navBar = new NavBar();

        navBar.addNavLink(new DependentClaimsPage(user.getUserId()), "My Claims");
        navBar.addNavLink(PageFactoryManager.getFactory().createMyProfilePage(), "My Profile");
        navBar.addNavLink(new LoginPage(), "Logout");
        return navBar;
    }
}
