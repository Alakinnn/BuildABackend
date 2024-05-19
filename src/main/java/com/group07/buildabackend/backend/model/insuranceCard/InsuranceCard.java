package com.group07.buildabackend.backend.model.insuranceCard;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "insurance_card")
public class InsuranceCard {
    @Id
    @GenericGenerator(
            name = CustomIDGenerator.GENERATOR_NAME,
            strategy = "com.group07.buildabackend.backend.utils.idGenerator.CardNumberGenerator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomIDGenerator.GENERATOR_NAME)
    @Column(name = "card_number")
    private String cardNumber;

    @OneToOne(mappedBy = "insuranceCard")
    private Beneficiary beneficiary;

//    Default expiry date is plus 6 years, may want to add a user with bad expiry date for testing
    @Column(name = "expiry_date")
    private LocalDate expiryDate = LocalDate.now().plusYears(6);

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
