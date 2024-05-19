package com.group07.buildabackend.gui.pages.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.admin.SystemAdminClaimViewPage;
import com.group07.buildabackend.gui.pages.admin.SystemAdminMyProfilePage;
import com.group07.buildabackend.gui.pages.admin.SystemAdminPublicProfilePage;
import com.group07.buildabackend.gui.pages.admin.SystemAdminUsersPage;

import java.util.function.Consumer;

public class SystemAdminPageFactory extends PageFactory{
    @Override
    public Page createDefaultPage() {
        return new SystemAdminUsersPage();
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new SystemAdminClaimViewPage(claimId);
    }

    @Override
    public Page createMyProfilePage() {
        return new SystemAdminMyProfilePage();
    }

    @Override
    public void createPublicProfilePage(String targetUserId, Consumer<Page> onSuccess) {
        onSuccess.accept(new SystemAdminPublicProfilePage(targetUserId));
    }
}
