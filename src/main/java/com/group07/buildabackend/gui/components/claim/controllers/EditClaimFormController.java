package com.group07.buildabackend.gui.components.claim.controllers;

import com.group07.buildabackend.backend.controller.InsuranceClaimController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimDTO;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.UpdateClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class EditClaimFormController extends FormController<InsuranceClaim> implements ComponentController {
    @FXML
    private Text claimId;
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

    private InsuranceClaim fetchClaim() {
        InsuranceClaimController controller = new InsuranceClaimController();
        return controller.retrieveById(claimId.getText()).getData();
    }

    public void initPage(String claimId) {
        this.claimId.setText(claimId);

        TaskRunner<InsuranceClaim> runner = new TaskRunner<>(this::fetchClaim, claim -> {

            insuredCustomerChoice.setValue(new ChoiceField<>(claim.getCustomer().getFullName(), claim.getCustomer().getUserId()));
            claimAmountField.setText(Double.toString(claim.getAmount()));
            examDatePicker.setValue(claim.getExamDate());
            bankNameField.setText(claim.getReceiverBankName());
            receiverNameField.setText(claim.getReceiverName());
            accountNumberField.setText(claim.getReceiverBankNumber());
        });

        runner.run();
    }

    @Override
    public Response<InsuranceClaim> sendFormRequest() {
        UpdateClaimDTO dto = new UpdateClaimDTO();
        dto.setClaimId(claimId.getText());
        dto.setClaimAmount(Double.parseDouble(claimAmountField.getText()));
        dto.setExamDate(examDatePicker.getValue());
        dto.setBankName(bankNameField.getText());
        dto.setReceiverName(receiverNameField.getText());
        dto.setAccountNumber(accountNumberField.getText());

        InsuranceClaimController controller = new InsuranceClaimController();
        return controller.updateClaim(dto);
    }
}
