package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SurveyorInsuranceClaimViewController implements Initializable, ComponentController {
    @FXML
    public ChoiceBox<ChoiceField<String>> claimChoice;
    @FXML
    public TextField statusField;
    @FXML
    public TextField claimAmountField;
    @FXML
    public TextField examDateField;
    @FXML
    public TextField claimDateField;
    @FXML
    public TextField receiverNameField;
    @FXML
    public TextField accountNumberField;
    @FXML
    public TextField bankNameField;
    @FXML
    public ChoiceBox<ChoiceField<String>> documentChoice;

//    TODO: I think there should be a field to hold the claim being viewed

    //    private ClaimDTO claim;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        claimChoice.getItems().add(new ChoiceField<>("f123", "123"));
        claimChoice.getItems().add(new ChoiceField<>("f234", "234"));
        claimChoice.getItems().add(new ChoiceField<>("f567", "567"));
    }

    public void handleClaimSelection(ActionEvent actionEvent) {
        String selectedClaimId = claimChoice.getValue().getValue();

//        ClaimInfoResponse claim = _beController_.find(selectedClaimId);

        // Populate text fields with claim data
//        statusField.setText(claim.getStatus());
//        claimAmountField.setText(String.valueOf(claim.getClaimAmount()));
        // others
    }

    public void handleDocumentSelection(ActionEvent actionEvent) {
        // TODO: Backend method to retrieve document
    }

    public void handleProposeClaim(ActionEvent actionEvent) {
    }

    public void handleRequestInfo(ActionEvent actionEvent) {
    }
}
