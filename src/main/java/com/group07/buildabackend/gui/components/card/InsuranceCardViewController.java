package com.group07.buildabackend.gui.components.card;

import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.gui.components.ComponentController;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class InsuranceCardViewController implements ComponentController {
    @FXML
    private Text cardNumber;
    @FXML
    private Text expiryDate;

    public void setCard(InsuranceCard card) {
        cardNumber.setText(card.getCardNumber());
        expiryDate.setText(card.getExpiryDate().toString());
    }
}
