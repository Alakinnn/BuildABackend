package com.group07.buildabackend.gui.components.nav.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.nav.NavBar;
import com.group07.buildabackend.gui.pages.auth.LoginPage;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.surveyor.InsuranceSurveyorClaimsPage;

public class InsuranceSurveyorNavBarFactory implements NavBarFactory{

    @Override
    public NavBar createNavBar() {
        NavBar navBar = new NavBar();

        navBar.addNavLink(new InsuranceSurveyorClaimsPage(), "Claims");
        navBar.addNavLink(PageFactoryManager.getFactory().createMyProfilePage(), "My Profile");
        navBar.addNavLink(new LoginPage(), "Logout");
        return navBar;
    }
}
