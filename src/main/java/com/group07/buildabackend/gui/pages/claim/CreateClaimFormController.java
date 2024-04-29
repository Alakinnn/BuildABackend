package com.group07.buildabackend.gui.pages.claim;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.sample.ClaimCreationRequest;
import com.group07.buildabackend.gui.utils.ChoiceField;
import com.group07.buildabackend.gui.components.upload.FileFilter;
import com.group07.buildabackend.gui.components.upload.FileUpload;
import com.group07.buildabackend.gui.components.upload.PDFFilterDecorator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateClaimFormController implements Initializable, ComponentController {
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
    private List<File> uploadedDocs;

    public CreateClaimFormController() {
        uploadedDocs = new ArrayList<>();
        docUploader = new FileUpload(new PDFFilterDecorator(new FileFilter()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadedDocsContainer.getChildren().add(docUploader.getRoot());

        // TODO: Add actual users
        insuredCustomerChoice.getItems().add(new ChoiceField<>("John - 123", "123"));
        insuredCustomerChoice.getItems().add(new ChoiceField<>("Mary - 456", "456"));
        insuredCustomerChoice.getItems().add(new ChoiceField<>("Bob - 789", "789"));
    }


    public void onUploadDocument() {
        uploadedDocs = docUploader.onUpload();
    }

    public void onSubmit(ActionEvent event) {
        try {
            ClaimCreationRequest request = new ClaimCreationRequest();
            request.setCustomerId(insuredCustomerChoice.getValue().getValue());
            request.setClaimAmount(Double.parseDouble(claimAmountField.getText()));
            request.setExamDate(examDatePicker.getValue());
            request.setBankName(bankNameField.getText());
            request.setReceiverName(receiverNameField.getText());
            request.setAccountNumber(accountNumberField.getText());
            request.setDocuments(uploadedDocs);

            // TODO: pass request to backend controller
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
