package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.backend.controller.InsuranceSurveyorController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.RequestClaimInfoDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormTextArea;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.exceptions.MissingRequiredFieldException;
import com.group07.buildabackend.gui.sample.ClaimRequestInfoRequest;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestClaimInfoFormController extends FormController implements ComponentController, Initializable {
    private TextArea notes;
    @FXML
    private Text claimId;

    public void setClaimId(String newId) {
        claimId.setText(newId);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addRequiredField(new FormTextArea(notes, "Notes"));
    }

    public void onSubmit(ActionEvent event) {
        try {
            checkRequiredFields();

            RequestClaimInfoDTO dto = new RequestClaimInfoDTO();
            dto.setClaimId(claimId.getText());
            dto.setNotes(notes.getText());

            InsuranceSurveyorController controller = new InsuranceSurveyorController();
            Response<InsuranceClaim> res = controller.requestClaimInfo(dto);

            if (res.getData() == null) {
                AlertManager.showError(res.getResponseMsg());
                return;
            }

            AlertManager.showInfo(res.getResponseMsg());
        } catch (Exception e) {
            AlertManager.showError(e.getMessage());
        }
    }
}
