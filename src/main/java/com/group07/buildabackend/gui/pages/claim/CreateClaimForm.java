package com.group07.buildabackend.gui.pages.claim;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.utils.ChoiceField;

import java.util.List;

public class CreateClaimForm extends ControlledComponent<CreateClaimFormController> {
    public CreateClaimForm() {
        super(CreateClaimForm.class.getResource("CreateClaimForm.fxml"));
    }

    public void setCustomerChoices(List<ChoiceField<String>> choices) {
        controller.setCustomerChoices(choices);
    }
}
