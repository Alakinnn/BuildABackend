package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.components.holder.PolicyHolderClaimViewPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderClaimsPage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderDependentProfilePage;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderMyProfilePage;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;
import com.group07.buildabackend.gui.tasks.TaskRunner;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class PolicyHolderPageFactory extends PageFactory{
    @Override
    public Page createDefaultPage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new PolicyHolderClaimsPage(user.getUserId());
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new PolicyHolderClaimViewPage(claimId);
    }

    @Override
    public Page createMyProfilePage() {
        return new PolicyHolderMyProfilePage();
    }

    @Override
    public void createPublicProfilePage(String targetUserId, Consumer<Page> onSuccess) {
        this.targetUserId = targetUserId;
        TaskRunner<SystemUser> runner = new TaskRunner<>(this::fetchUser, targetUser -> {
            Page page;

            page = switch (targetUser.getUserType()) {
                case dependent -> new PolicyHolderDependentProfilePage(targetUserId);
                default -> new UserProfilePage(targetUserId);
            };

            onSuccess.accept(page);
        });
        runner.run();
    }
}
