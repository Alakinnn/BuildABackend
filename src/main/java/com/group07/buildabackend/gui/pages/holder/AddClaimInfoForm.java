package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.Component;

public class AddClaimInfoForm extends Component<AddClaimInfoFormController> {
    public AddClaimInfoForm(String claimId) {
        super(AddClaimInfoForm.class.getResource("AddClaimInfoForm.fxml"));
        controller.setClaimId(claimId);
    }
}
