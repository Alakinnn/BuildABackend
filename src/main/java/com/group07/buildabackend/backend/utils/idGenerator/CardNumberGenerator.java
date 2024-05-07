package com.group07.buildabackend.backend.utils.idGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import jakarta.persistence.Query;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CardNumberGenerator implements IdentifierGenerator {
    public static final String GENERATOR_NAME = "cardNumberGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            sb.append(random.nextInt(10));
            if ((i + 1) % 4 == 0 && i != 11) {
                sb.append(" "); // Add space every 4 digits
            }
        }
        return sb.toString();
    }
}
