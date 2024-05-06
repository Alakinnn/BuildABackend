package com.group07.buildabackend.gui.pages.manager;

import com.group07.buildabackend.backend.controller.InsuranceManagerController;
import com.group07.buildabackend.backend.controller.Response;
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

public class ManagerInsuranceClaimViewController implements Initializable, ComponentController {
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

    public void rejectClaim(ActionEvent actionEvent) {
        InsuranceManagerController controller = new InsuranceManagerController();
        String id = claimId.getText();
        Response<InsuranceClaim> res = controller.rejectClaim(id);

        if (res.getData() == null) {
            AlertManager.showError(res.getResponseMsg());
            return;
        }

        AlertManager.showInfo(res.getResponseMsg());
    }

    public void approveClaim(ActionEvent actionEvent) {
        InsuranceManagerController controller = new InsuranceManagerController();
        String id = claimId.getText();
        Response<InsuranceClaim> res = controller.approveClaim(id);

        if (res.getData() == null) {
            AlertManager.showError(res.getResponseMsg());
            return;
        }

        AlertManager.showInfo(res.getResponseMsg());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setClaimId(String claimId) {
        this.claimId.setText(claimId);
    }
}
