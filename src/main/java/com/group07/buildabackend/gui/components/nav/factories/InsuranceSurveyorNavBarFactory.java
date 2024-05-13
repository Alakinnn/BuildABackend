package com.group07.buildabackend.gui.components.nav.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.dependent.DependentClaimsPage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;

public class InsuranceSurveyorNavBarFactory implements NavBarFactory{

    @Override
    public NavBar createNavBar() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        NavBar navBar = new NavBar();

        navBar.addNavLink(new UserProfilePage(user.getUserId()), "Profile");
        return navBar;
    }
}
