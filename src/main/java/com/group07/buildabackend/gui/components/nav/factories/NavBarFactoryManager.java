package com.group07.buildabackend.gui.components.nav.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;

public class NavBarFactoryManager {
    private static NavBarFactory factory;

    public static NavBarFactory getFactory() {
        if (factory == null) {
            factory = createFactory();
        }
        return factory;
    }

    public static void refreshFactory() {
        factory = createFactory();
    }

    private static NavBarFactory createFactory() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return switch (user.getUserType()) {
            case policy_holder -> new PolicyHolderNavBarFactory();
            case dependent -> new DependentNavBarFactory();
            case policy_owner -> new PolicyOwnerNavBarFactory();
            case insurance_surveyor -> new InsuranceSurveyorNavBarFactory();
            case insurance_manager -> new InsuranceManagerNavBarFactory();
            case system_admin -> new SystemAdminNavBarFactory();
        };
    }
}
