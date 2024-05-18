package com.group07.buildabackend.gui.components.admin.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.AdminController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.authenticationDTO.RegisterInfoDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.provider.InsuranceManager;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormChoiceBox;
import com.group07.buildabackend.gui.components.form.fields.FormPasswordField;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.components.user.CreateUserForm;
import com.group07.buildabackend.gui.components.user.controllers.CreateUserFormController;
import com.group07.buildabackend.gui.utils.AlertManager;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SystemAdminCreateOtherUserFormController extends FormController<SystemUser> implements ComponentController, Initializable {
    @FXML
    private ChoiceBox<ChoiceField<String>> roleChoice;


    @FXML
    private HBox createUserFormContainer;

    private CreateUserFormController userFormController;

    private enum UserRoleOption {
        insurance_manager,
        insurance_surveyor
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CreateUserForm form = new CreateUserForm();
        userFormController = form.getController();

        createUserFormContainer.getChildren().add(form.getRoot());
        addRequiredField(new FormChoiceBox<>(roleChoice, "User Role"));
        addRequiredField(new FormTextField(userFormController.firstNameField, "First Name"));
        addRequiredField(new FormTextField(userFormController.lastNameField, "Last Name"));
        addRequiredField(new FormTextField(userFormController.emailField, "Email"));
        addRequiredField(new FormTextField(userFormController.phoneField, "Phone Number"));
        addRequiredField(new FormTextField(userFormController.addressField, "Address"));
        addRequiredField(new FormPasswordField(userFormController.passwordField, "Password"));
        addRequiredField(new FormPasswordField(userFormController.confirmPasswordField, "Confirm Password"));

        roleChoice.getItems().add(new ChoiceField<>("Insurance Manager", UserRoleOption.insurance_manager.toString()));
        roleChoice.getItems().add(new ChoiceField<>("Insurance Surveyor", UserRoleOption.insurance_surveyor.toString()));

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
    public Response<SystemUser> sendFormRequest() {
        AdminController controller = new AdminController();

        Response<SystemUser> res = new Response<>(null);
        String msg;

        // This is really bad, but im so tired, sorry.
        return switch (UserRoleOption.valueOf(roleChoice.getValue().getValue())) {
            case insurance_manager:
                InsuranceManagerDTO managerDTO = new InsuranceManagerDTO();
                setDto(managerDTO);
                Response<InsuranceManager> managerResponse = controller.createInsuranceManager(managerDTO);
                res.setData(managerResponse.getData());
                msg = managerResponse.getResponseMsg();
                res.setResponseMsg(msg);
                res.setStatusCode(200);
                yield res;
            case insurance_surveyor:
                InsuranceSurveyorDTO surveyorDTO = new InsuranceSurveyorDTO();
                setDto(surveyorDTO);
                Response<InsuranceSurveyor> surveyorResponse = controller.createInsuranceSurveyor(surveyorDTO);
                res.setData(surveyorResponse.getData());
                msg = surveyorResponse.getResponseMsg();
                res.setResponseMsg(msg);
                res.setStatusCode(200);
                yield res;
        };

    }

    private void setDto(RegisterInfoDTO dto) {
        dto.setFirstName(userFormController.firstNameField.getText());
        dto.setLastName(userFormController.lastNameField.getText());
        dto.setEmail(userFormController.emailField.getText());
        dto.setAddress(userFormController.addressField.getText());
        dto.setPhone(userFormController.phoneField.getText());
        dto.setPwd(userFormController.passwordField.getText());
    }
}
