package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.components.ComponentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class RequestClaimInfoFormController implements ComponentController {
    public TextArea notes;
    @FXML
    private Text claimId;

    public void setClaimId(String newId) {
        claimId.setText(newId);
    }

    public void onSubmit(ActionEvent event) {

    }
}
