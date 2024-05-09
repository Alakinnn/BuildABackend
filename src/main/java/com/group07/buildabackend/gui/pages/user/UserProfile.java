package com.group07.buildabackend.gui.pages.user;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class UserProfile extends ControlledComponent<UserProfileController> {
    public UserProfile(String userId) {
        super(UserProfile.class.getResource("UserProfile.fxml"));
        controller.initPage(userId);
    }
}
