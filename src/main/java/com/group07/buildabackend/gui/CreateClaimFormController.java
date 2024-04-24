package com.group07.buildabackend.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateClaimFormController implements Initializable {
    @FXML
    private ChoiceBox<ChoiceField<String>> insuredCustomerChoice;
    @FXML
    private TextField claimAmountField;
    @FXML
    private DatePicker examDatePicker;

    private String insuredCustomer;
    private double claimAmount;
    private LocalDate examDate;

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

            System.out.println(insuredCustomer);
            System.out.println(claimAmount);
            System.out.println(examDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
