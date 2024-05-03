package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormTextArea;
import com.group07.buildabackend.gui.components.form.fields.FormTextField;
import com.group07.buildabackend.gui.exceptions.MissingRequiredFieldException;
import com.group07.buildabackend.gui.sample.ClaimRequestInfoRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestClaimInfoFormController extends FormController implements ComponentController, Initializable {
    public TextArea notes;
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

            ClaimRequestInfoRequest request = new ClaimRequestInfoRequest();
            request.setClaimId(claimId.getText());
            request.setNotes(notes.getText());

            // TODO: pass to backend
        } catch (MissingRequiredFieldException e) {
            System.out.println(e.getMessage());
        }
    }
}
