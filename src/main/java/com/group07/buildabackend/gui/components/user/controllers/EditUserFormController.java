package com.group07.buildabackend.gui.components.user.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.dto.user.UpdateUserDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class EditUserFormController extends FormController<SystemUser> implements ComponentController {
    @FXML
    private Text userId;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField addressField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;


    @Override
    public Response<SystemUser> sendFormRequest() {
        UpdateUserDTO dto = new UpdateUserDTO();
        dto.setUserId(userId.getText());
        dto.setFirstName(firstNameField.getText());
        dto.setLastName(lastNameField.getText());
        dto.setEmail(emailField.getText());
        dto.setAddress(addressField.getText());
        dto.setPhone(phoneField.getText());

        if (!passwordField.getText().isEmpty()) {
            dto.setPassword(passwordField.getText());
        }

        UserController controller = new UserController();

        return controller.updateUser(dto);
    }

    @Override
    public boolean preSubmit() {
        if (passwordField.getText().isEmpty() && confirmPasswordField.getText().isEmpty()) {
            return true;
        }

        if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            AlertManager.showError("Confirm password does not match");
            return false;
        }

        return true;
    }

    private SystemUser fetchUser() {
        SystemUserRepository repo = new SystemUserRepository();
        return repo.retrieveActorById(userId.getText());
    }

    public void initPage(String userId) {
        this.userId.setText(userId);

        TaskRunner<SystemUser> runner = new TaskRunner<>(this::fetchUser, user -> {
            firstNameField.setText(user.getFirstName());
            lastNameField.setText(user.getLastName());
            emailField.setText(user.getEmail());
            phoneField.setText(user.getPhone());
            addressField.setText(user.getAddress());
        });
        runner.run();
    }


}
