package com.group07.buildabackend.gui.pages.user;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class UserProfileController implements ComponentController {
    @FXML
    private Text id;
    @FXML
    private Text fullName;
    @FXML
    private Text email;
    @FXML
    private Text address;
    @FXML
    private Text phone;
    @FXML
    private Text role;

    public void initPage(String userId) {
        try {
            SystemUserRepository repo = new SystemUserRepository();
            SystemUser user = repo.retrieveActorById(userId);

            if (user == null) return;

            id.setText(user.getUserId());
            fullName.setText(user.getFullName());
            email.setText(user.getEmail());
            address.setText(user.getAddress());
            phone.setText(user.getPhone());

            // TODO: BE need to implement a role for each user
//            role.setText(user.getRole());


        } catch (Exception e) {
            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }
    }
}
