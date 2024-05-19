package com.group07.buildabackend.gui.components.surveyor.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.InsuranceSurveyorController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.RequestClaimInfoDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormTextArea;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.exceptions.MissingRequiredFieldException;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestClaimInfoFormController extends FormController<InsuranceClaim> implements ComponentController, Initializable {
    @FXML
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

    @Override
    public Response<InsuranceClaim> sendFormRequest() {
        RequestClaimInfoDTO dto = new RequestClaimInfoDTO();
        dto.setClaimId(claimId.getText());
        dto.setNotes(notes.getText());

        InsuranceSurveyorController controller = new InsuranceSurveyorController();
        return controller.requestClaimInfo(dto);
    }
}
