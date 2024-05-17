package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.gui.pages.Page;

import java.util.function.Consumer;

public abstract class PageFactory {
    public abstract Page createDefaultPage();
    public abstract Page createClaimViewPage(String claimId);
    public abstract Page createMyProfilePage();

    // Since we need to fetch user and check viewing permission,
    // this method accepts a call back after page creation is done.
    public abstract void createPublicProfilePage(String targetUserId, Consumer<Page> onSuccess);

    protected String targetUserId;

    protected SystemUser fetchUser() {
        UserController controller = new UserController();
        return controller.retrieveById(targetUserId).getData();
    }
}
