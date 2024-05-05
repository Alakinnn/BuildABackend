package com.group07.buildabackend.backend.model.insuranceCard;

import com.group07.buildabackend.backend.model.customer.Customer;
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
    private Customer customer;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
