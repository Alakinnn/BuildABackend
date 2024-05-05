package com.group07.buildabackend.backend.connectionManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseFactoryManager {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("com.group07");
            return emf;
        }
        return emf;
    }
}
