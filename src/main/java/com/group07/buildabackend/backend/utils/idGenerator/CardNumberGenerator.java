package com.group07.buildabackend.backend.utils.idGenerator;

import java.io.Serializable;
import java.util.Random;

import jakarta.persistence.Query;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CardNumberGenerator implements IdentifierGenerator {
    public static final String GENERATOR_NAME = "cardNumberGenerator";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String cardNumber = generateRandomCardNumber();

        while (isCardNumberExists(session, cardNumber)) {
            cardNumber = generateRandomCardNumber();
        }

        return cardNumber;
    }

    private String generateRandomCardNumber() {
        Random rand = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            if (i % 4 == 0 && i != 0) {
                cardNumber.append(" ");
            }
            cardNumber.append(rand.nextInt(10));
        }
        return cardNumber.toString();
    }

    private boolean isCardNumberExists(SharedSessionContractImplementor session, String cardNumber) {
        String queryString = "SELECT COUNT(*) FROM InsuranceCard WHERE id = :id";
        Query query = session.createQuery(queryString, Long.class);
        query.setParameter("id", cardNumber);

        return query.getResultList().isEmpty() ? true : false;
    }
}

