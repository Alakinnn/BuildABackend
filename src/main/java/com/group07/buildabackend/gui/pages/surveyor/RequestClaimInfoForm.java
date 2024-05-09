package com.group07.buildabackend.gui.pages.surveyor;

import com.group07.buildabackend.gui.components.ControlledComponent;

public class RequestClaimInfoForm extends ControlledComponent<RequestClaimInfoFormController> {
    public RequestClaimInfoForm(String claimId) {
        super(RequestClaimInfoForm.class.getResource("RequestClaimInfoForm.fxml"));
        controller.setClaimId(claimId);
    }
}
