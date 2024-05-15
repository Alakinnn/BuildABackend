package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.user.controllers.UserProfileController;
import com.group07.buildabackend.gui.components.utils.ActionField;

public class UserProfile extends ControlledComponent<UserProfileController> {
    public UserProfile(String userId) {
        super(UserProfile.class.getResource("UserProfile.fxml"));
        controller.initPage(userId);
    }

    public UserProfile(String userId, ActionField field) {
        super(UserProfile.class.getResource("UserProfile.fxml"));
        controller.initPage(userId);
        controller.setActionField(field);
    }
}
