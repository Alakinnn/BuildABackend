package com.group07.buildabackend.gui.factories;

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

    private static PageFactory createFactory() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        switch (user.getUserType()) {
            case policy_holder:
                return new PolicyHolderPageFactory();

            default:
                return null;
        }
    }
}
