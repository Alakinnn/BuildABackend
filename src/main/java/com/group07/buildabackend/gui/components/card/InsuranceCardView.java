package com.group07.buildabackend.gui.components.card;

import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.card.controllers.InsuranceCardViewController;

public class InsuranceCardView extends ControlledComponent<InsuranceCardViewController> {
    public InsuranceCardView(InsuranceCard card) {
        super(InsuranceCardView.class.getResource("InsuranceCardView.fxml"));
        controller.setCard(card);
    }
}
