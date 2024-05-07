package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.backend.controller.InsuranceSurveyorController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.ProposeClaimDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SurveyorInsuranceClaimViewController implements Initializable, ComponentController {

    @FXML
    private Text claimId;
    @FXML
    private TextField statusField;
    @FXML
    private TextField claimAmountField;
    @FXML
    private TextField examDateField;
    @FXML
    private TextField claimDateField;
    @FXML
    private TextField receiverNameField;
    @FXML
    private TextField accountNumberField;
    @FXML
    private TextField bankNameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void handleProposeClaim(ActionEvent actionEvent) {
        InsuranceSurveyorController controller = new InsuranceSurveyorController();

        ProposeClaimDTO dto = new ProposeClaimDTO();
        dto.setId(claimId.getText());

        Response<InsuranceClaim> res = controller.proposeClaim(dto);

        if (res.getData() == null) {
            AlertManager.showError(res.getResponseMsg());
            return;
        }

        AlertManager.showInfo(res.getResponseMsg());
    }

    public void handleRequestInfo(ActionEvent actionEvent) {
        RequestClaimInfoPage page = new RequestClaimInfoPage(claimId.getText());
        SceneManager.getInstance().switchToPage(page);
    }

    public void setClaimId(String claimId) {
        this.claimId.setText(claimId);
    }
}
