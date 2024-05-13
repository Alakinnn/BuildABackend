package com.group07.buildabackend.gui.pages.user;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.user.UserActionList;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

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
    @FXML
    private HBox actionListContainer;

    public void initPage(String userId) {
        try {
            // TODO: Use controller
            SystemUserRepository repo = new SystemUserRepository();
            SystemUser user = repo.retrieveActorById(userId);

            if (user == null) return;

            id.setText(user.getUserId());
            fullName.setText(user.getFullName());
            email.setText(user.getEmail());
            address.setText(user.getAddress());
            phone.setText(user.getPhone());
            role.setText(user.getUserType().toString());

            actionListContainer.getChildren().add(new UserActionList(userId).getRoot());

        } catch (Exception e) {
            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }
    }

}
