package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.backend.controller.InsuranceSurveyorController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.ProposeClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.utils.AlertManager;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SurveyorInsuranceClaimViewController implements Initializable, ComponentController {

    @FXML
    public Text claimId;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void handleDocumentSelection(ActionEvent actionEvent) {
        // TODO: Backend method to retrieve document
    }

    public void handleProposeClaim(ActionEvent actionEvent) {
        InsuranceSurveyorController controller = new InsuranceSurveyorController();

        ProposeClaimDTO dto = new ProposeClaimDTO();
        dto.setClaimId(claimId.getText());

        Response<InsuranceClaim> res = controller.proposeClaim(dto);

        if (res.getData() == null) {
            AlertManager.showError(res.getResponseMsg());
            return;
        }

        AlertManager.showInfo(res.getResponseMsg());
    }

    public void handleRequestInfo(ActionEvent actionEvent) {

    }

    public void setClaimId(String claimId) {
        this.claimId.setText(claimId);
    }
}
