package com.group07.buildabackend.gui.components.owner.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.PolicyHolderController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;
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

public class PolicyOwnerCreateDependentFormController extends FormController<Dependent> implements ComponentController, Initializable {
    @FXML
    private ChoiceBox<ChoiceField<String>> policyHolderChoice;

    @FXML
    private HBox createUserFormContainer;

    private CreateUserFormController userFormController;

    private String poId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CreateUserForm form = new CreateUserForm();
        userFormController = form.getController();

        createUserFormContainer.getChildren().add(form.getRoot());
        addRequiredField(new FormChoiceBox<>(policyHolderChoice, "Policy Holder"));
        addRequiredField(new FormTextField(userFormController.firstNameField, "First Name"));
        addRequiredField(new FormTextField(userFormController.lastNameField, "Last Name"));
        addRequiredField(new FormTextField(userFormController.emailField, "Email"));
        addRequiredField(new FormTextField(userFormController.phoneField, "Phone Number"));
        addRequiredField(new FormTextField(userFormController.addressField, "Address"));
        addRequiredField(new FormPasswordField(userFormController.passwordField, "Password"));
        addRequiredField(new FormPasswordField(userFormController.confirmPasswordField, "Confirm Password"));

    }

    private List<PolicyHolder> fetchPolicyHolders() {
        // TODO: User controller
        PolicyOwnerRepository repo = new PolicyOwnerRepository();
        return repo.retrieveAllPolicyHolders(poId);
    }

    public void initPage(String poId) {
        this.poId = poId;
        TaskRunner<List<PolicyHolder>> runner = new TaskRunner<>(this::fetchPolicyHolders, holders -> {
            for (PolicyHolder holder: holders) {
                String label = holder.getFullName() + " (" + holder.getUserId() + ")";
                policyHolderChoice.getItems().add(new ChoiceField<>(label, holder.getUserId()));
            }
        });
        runner.run();
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
    public Response<Dependent> sendFormRequest() {
        DependentDTO dto = new DependentDTO();

        dto.setPolicyHolderId(policyHolderChoice.getValue().getValue());
        dto.setFirstName(userFormController.firstNameField.getText());
        dto.setLastName(userFormController.lastNameField.getText());
        dto.setEmail(userFormController.emailField.getText());
        dto.setAddress(userFormController.addressField.getText());
        dto.setPhone(userFormController.phoneField.getText());
        dto.setPwd(userFormController.passwordField.getText());

        PolicyHolderController controller = new PolicyHolderController();

        return controller.createNewDependent(dto);
    }

}
