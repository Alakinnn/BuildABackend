package com.group07.buildabackend.gui.components.admin.controllers;

import com.group07.buildabackend.backend.controller.AdminController;
import com.group07.buildabackend.backend.controller.PolicyOwnerController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormChoiceBox;
import com.group07.buildabackend.gui.components.form.fields.FormPasswordField;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.components.user.CreateUserForm;
import com.group07.buildabackend.gui.components.user.controllers.CreateUserFormController;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.AlertManager;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SystemAdminCreateHolderFormController extends FormController<PolicyHolder> implements Initializable, ComponentController {
    @FXML
    private ChoiceBox<ChoiceField<String>> policyOwnerChoice;

    @FXML
    private HBox createUserFormContainer;

    private CreateUserFormController userFormController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CreateUserForm form = new CreateUserForm();
        userFormController = form.getController();

        createUserFormContainer.getChildren().add(form.getRoot());
        addRequiredField(new FormChoiceBox<>(policyOwnerChoice, "Policy Holder"));
        addRequiredField(new FormTextField(userFormController.firstNameField, "First Name"));
        addRequiredField(new FormTextField(userFormController.lastNameField, "Last Name"));
        addRequiredField(new FormTextField(userFormController.emailField, "Email"));
        addRequiredField(new FormTextField(userFormController.phoneField, "Phone Number"));
        addRequiredField(new FormTextField(userFormController.addressField, "Address"));
        addRequiredField(new FormPasswordField(userFormController.passwordField, "Password"));
        addRequiredField(new FormPasswordField(userFormController.confirmPasswordField, "Confirm Password"));

        TaskRunner<List<SystemUser>> runner = new TaskRunner<>(this::fetchPolicyOwners, owners -> {
            if (owners == null) return;

            for (SystemUser owner: owners) {
                String label = owner.getFirstName() + " (" + owner.getUserId() + ")";
                policyOwnerChoice.getItems().add(new ChoiceField<>(label, owner.getUserId()));
            }
        });
        runner.run();
    }

    private List<SystemUser> fetchPolicyOwners() {
        PolicyOwnerController controller = new PolicyOwnerController();
        return controller.retrieveAll().getData();
    }

    @Override
    public boolean preSubmit() {
        if (!userFormController.passwordField.getText().equals(userFormController.confirmPasswordField.getText())) {
            AlertManager.showError("Confirm password does not match");
            return false;
        }
        return true;
    }

    @Override
    public Response<PolicyHolder> sendFormRequest() {
        PolicyHolderDTO dto = new PolicyHolderDTO();

        dto.setPolicyOwnerId(policyOwnerChoice.getValue().getValue());
        dto.setFirstName(userFormController.firstNameField.getText());
        dto.setLastName(userFormController.lastNameField.getText());
        dto.setEmail(userFormController.emailField.getText());
        dto.setAddress(userFormController.addressField.getText());
        dto.setPhone(userFormController.phoneField.getText());
        dto.setPwd(userFormController.passwordField.getText());

        AdminController controller = new AdminController();

        return controller.createNewPolicyHolder(dto);
    }
}
