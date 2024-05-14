package com.group07.buildabackend.gui.pages.dependent;

import com.group07.buildabackend.backend.controller.PolicyHolderController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormChoiceBox;
import com.group07.buildabackend.gui.components.form.fields.FormPasswordField;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.pages.user.CreateUserForm;
import com.group07.buildabackend.gui.pages.user.CreateUserFormController;
import com.group07.buildabackend.gui.utils.AlertManager;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateDependentFormController extends FormController<Dependent> implements ComponentController, Initializable {
    @FXML
    private ChoiceBox<ChoiceField<String>> policyHolderChoice;

    @FXML
    private HBox createUserFormContainer;

    private CreateUserFormController userFormController;

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

    public void presetPolicyHolderId(String phId) {
        policyHolderChoice.setValue(new ChoiceField<>("Myself", phId));
        policyHolderChoice.setDisable(true);
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
