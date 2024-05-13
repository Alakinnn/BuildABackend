package com.group07.buildabackend.gui.components.nav.factories;

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

    private static NavBarFactory createFactory() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        switch (user.getUserType()) {
            case policy_holder:
                return new PolicyHolderNavBarFactory();
            case dependent:
                return new DependentNavBarFactory();
            case policy_owner:
                return new PolicyOwnerNavBarFactory();
            case insurance_surveyor:
                return new InsuranceSurveyorNavBarFactory();
            case insurance_manager:
                return new InsuranceManagerNavBarFactory();
            // TODO: add system admin
            default:
                return null;
        }
    }
}
