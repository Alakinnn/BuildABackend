package com.group07.buildabackend.gui.pages.claim;

import com.group07.buildabackend.gui.ChoiceField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateClaimForm implements Initializable {
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

    private String insuredCustomer;
    private double claimAmount;
    private LocalDate examDate;
    private String bankName;
    private String receiverName;
    private String accountNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO: Add actual users
        insuredCustomerChoice.getItems().add(new ChoiceField<>("John - 123", "123"));
        insuredCustomerChoice.getItems().add(new ChoiceField<>("Mary - 456", "456"));
        insuredCustomerChoice.getItems().add(new ChoiceField<>("Bob - 789", "789"));

    }

    public void onUploadDocument() {

    }

    public void onSubmit(ActionEvent event) {
        try {
            insuredCustomer = insuredCustomerChoice.getValue().getValue();
            claimAmount = Double.parseDouble(claimAmountField.getText());
            examDate = examDatePicker.getValue();
            bankName = bankNameField.getText();
            receiverName = receiverNameField.getText();
            accountNumber = accountNumberField.getText();

            System.out.println(insuredCustomer);
            System.out.println(claimAmount);
            System.out.println(examDate);
            System.out.println(bankName);
            System.out.println(receiverName);
            System.out.println(accountNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
