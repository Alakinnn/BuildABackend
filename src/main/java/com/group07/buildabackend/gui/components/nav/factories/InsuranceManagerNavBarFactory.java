package com.group07.buildabackend.gui.components.nav.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.auth.LoginPage;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.manager.InsuranceManagerClaimsPage;
import com.group07.buildabackend.gui.pages.manager.InsuranceManagerSurveyorsPage;

public class InsuranceManagerNavBarFactory implements NavBarFactory{
    @Override
    public NavBar createNavBar() {
        NavBar navBar = new NavBar();

        navBar.addNavLink(new InsuranceManagerClaimsPage(), "Claims");
        navBar.addNavLink(new InsuranceManagerSurveyorsPage(), "Surveyors");
        navBar.addNavLink(PageFactoryManager.getFactory().createMyProfilePage(), "My Profile");
        navBar.addNavLink(new LoginPage(), "Logout");
        return navBar;
    }
}
