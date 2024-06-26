package com.group07.buildabackend.gui.pages.factories;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.holder.PolicyHolderDependentProfilePage;
import com.group07.buildabackend.gui.pages.owner.*;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;
import com.group07.buildabackend.gui.tasks.TaskRunner;

import java.util.function.Consumer;

public class PolicyOwnerPageFactory extends PageFactory{
    @Override
    public Page createDefaultPage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new PolicyOwnerBeneficiariesPage(user.getUserId());
    }

    @Override
    public Page createClaimViewPage(String claimId) {
        return new PolicyOwnerClaimViewPage(claimId);
    }

    @Override
    public Page createMyProfilePage() {
        SystemUser user = CurrentUserManager.getCurrentUser();
        return new UserProfilePage(user.getUserId());
    }

    @Override
    public void createPublicProfilePage(String targetUserId, Consumer<Page> onSuccess) {
        this.targetUserId = targetUserId;
        TaskRunner<SystemUser> runner = new TaskRunner<>(this::fetchUser, targetUser -> {
            Page page;

            page = switch (targetUser.getUserType()) {
                case policy_holder -> new PolicyOwnerHolderProfilePage(targetUserId);
                case dependent -> new PolicyOwnerDependentProfilePage(targetUserId);
                default -> new UserProfilePage(targetUserId);
            };

            onSuccess.accept(page);
        });
        runner.run();
    }
}
