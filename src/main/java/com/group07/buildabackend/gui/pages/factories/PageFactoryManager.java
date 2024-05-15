package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;

public class PageFactoryManager {
    private static PageFactory factory;

    public static PageFactory getFactory() {
        if (factory == null) {
            factory = createFactory();
        }
        return factory;
    }

    public static void refreshFactory() {
        factory = createFactory();
    }

    private static PageFactory createFactory() {
        SystemUser user = CurrentUserManager.getCurrentUser();

        return switch (user.getUserType()) {
            case policy_holder -> new PolicyHolderPageFactory();
            case dependent -> new DependentPageFactory();
            case policy_owner -> new PolicyOwnerPageFactory();
            case insurance_surveyor -> new InsuranceSurveyorPageFactory();
            case insurance_manager -> new InsuranceManagerPageFactory();
            case system_admin -> new SystemAdminPageFactory();
        };
    }
}
