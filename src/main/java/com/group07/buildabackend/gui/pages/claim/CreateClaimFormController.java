package com.group07.buildabackend.gui.pages.claim;

import com.group07.buildabackend.backend.controller.PolicyHolderController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.*;
import com.group07.buildabackend.gui.components.form.fields.FormChoiceBox;
import com.group07.buildabackend.gui.components.form.fields.FormDatePicker;
import com.group07.buildabackend.gui.components.form.fields.FormFileUpload;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.exceptions.MissingRequiredFieldException;
import com.group07.buildabackend.gui.sample.ClaimCreationRequest;
import com.group07.buildabackend.gui.utils.AlertManager;
import com.group07.buildabackend.gui.utils.ChoiceField;
import com.group07.buildabackend.gui.components.upload.FileFilter;
import com.group07.buildabackend.gui.components.upload.FileUpload;
import com.group07.buildabackend.gui.components.upload.PDFFilterDecorator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateClaimFormController extends FormController implements Initializable, ComponentController {
    @FXML
    private ChoiceBox<ChoiceField<String>> insuredCustomerChoice;
    @FXML
    private TextField claimAmountField;
    @FXML
    private DatePicker examDatePicker;
    @FXML
    private TextField bankNameField;
    @FXML
    private TextField receiverNameField;
    @FXML
    private TextField accountNumberField;
    @FXML
    private AnchorPane uploadedDocsContainer;

    private FileUpload docUploader;

    public CreateClaimFormController() {
        super();
        docUploader = new FileUpload(new PDFFilterDecorator(new FileFilter()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadedDocsContainer.getChildren().add(docUploader.getRoot());

        populateCustomerChoices();

        addRequiredField(new FormChoiceBox<>(insuredCustomerChoice, "Insured Customer"));
        addRequiredField(new FormTextField(claimAmountField, "Claim Amount"));
        addRequiredField(new FormDatePicker(examDatePicker, "Exam Date"));
        addRequiredField(new FormTextField(bankNameField, "Bank Name"));
        addRequiredField(new FormTextField(receiverNameField, "Receiver Name"));
        addRequiredField(new FormTextField(accountNumberField, "Account Number"));
        addRequiredField(new FormFileUpload(docUploader, "Documents"));
    }

    private void populateCustomerChoices() {
        // TODO: Add actual users
        insuredCustomerChoice.getItems().add(new ChoiceField<>("John - 123", "123"));
        insuredCustomerChoice.getItems().add(new ChoiceField<>("Mary - u_dfeaa167", "u_dfeaa167"));
        insuredCustomerChoice.getItems().add(new ChoiceField<>("Bob - 789", "789"));
    }


    public void onUploadDocument() {
        docUploader.onUpload();
    }

    public void onSubmit(ActionEvent event) {
        try {
            checkRequiredFields();

            InsuranceClaimDTO dto = new InsuranceClaimDTO();
            dto.setCustomerId(insuredCustomerChoice.getValue().getValue());
            dto.setAmount(Double.parseDouble(claimAmountField.getText()));
            dto.setExamDate(examDatePicker.getValue().toString());
            dto.setReceiverBankName(bankNameField.getText());
            dto.setReceiverName(receiverNameField.getText());
            dto.setReceiverBankNumber(accountNumberField.getText());
            dto.setDocuments(docUploader.getUploadedFiles());

            // TODO: pass request to backend controller
            PolicyHolderController controller = new PolicyHolderController();
            Response<InsuranceClaim> res = controller.createClaim(dto);

            if (res.getData() == null) {
                AlertManager.showError(res.getResponseMsg());
            }

            AlertManager.showInfo(res.getResponseMsg());
        } catch (Exception e) {
            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }
    }


}
