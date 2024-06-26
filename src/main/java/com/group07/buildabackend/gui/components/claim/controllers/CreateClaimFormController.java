package com.group07.buildabackend.gui.components.claim.controllers;

/**
 * @author Group_7
 */

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
import com.group07.buildabackend.gui.utils.ChoiceField;
import com.group07.buildabackend.gui.components.upload.filters.FileFilter;
import com.group07.buildabackend.gui.components.upload.FileUpload;
import com.group07.buildabackend.gui.components.upload.filters.PDFFilterDecorator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreateClaimFormController extends FormController<InsuranceClaim> implements Initializable, ComponentController {
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
    public Response<InsuranceClaim> sendFormRequest() {
        InsuranceClaimDTO dto = new InsuranceClaimDTO();
        dto.setCustomerId(insuredCustomerChoice.getValue().getValue());
        dto.setAmount(Double.parseDouble(claimAmountField.getText()));
        dto.setExamDate(examDatePicker.getValue().toString());
        dto.setReceiverBankName(bankNameField.getText());
        dto.setReceiverName(receiverNameField.getText());
        dto.setReceiverBankNumber(accountNumberField.getText());
        dto.setDocuments(docUploader.getUploadedFiles());

        PolicyHolderController controller = new PolicyHolderController();
        return controller.createClaim(dto);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadedDocsContainer.getChildren().add(docUploader.getRoot());

        addRequiredField(new FormChoiceBox<>(insuredCustomerChoice, "Insured Customer"));
        addRequiredField(new FormTextField(claimAmountField, "Claim Amount"));
        addRequiredField(new FormDatePicker(examDatePicker, "Exam Date"));
        addRequiredField(new FormTextField(bankNameField, "Bank Name"));
        addRequiredField(new FormTextField(receiverNameField, "Receiver Name"));
        addRequiredField(new FormTextField(accountNumberField, "Account Number"));
        addRequiredField(new FormFileUpload(docUploader, "Documents"));
    }

    public void onUploadDocument() {
        docUploader.onUpload();
    }

    public void setCustomerChoices(List<ChoiceField<String>> choices) {
        insuredCustomerChoice.getItems().setAll(choices);
    }
}
