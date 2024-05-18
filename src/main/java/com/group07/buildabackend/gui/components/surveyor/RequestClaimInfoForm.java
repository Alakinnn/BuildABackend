package com.group07.buildabackend.gui.components.surveyor;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.surveyor.controllers.RequestClaimInfoFormController;

public class RequestClaimInfoForm extends ControlledComponent<RequestClaimInfoFormController> {
    public RequestClaimInfoForm(String claimId) {
        super(RequestClaimInfoForm.class.getResource("RequestClaimInfoForm.fxml"));
        controller.setClaimId(claimId);
    }
}
