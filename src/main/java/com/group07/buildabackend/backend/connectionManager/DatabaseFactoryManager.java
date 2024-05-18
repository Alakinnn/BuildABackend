package com.group07.buildabackend.backend.connectionManager;

/**
 * @author Group_7
 */

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

    public static void connectDB() {
        emf = Persistence.createEntityManagerFactory("com.group07");
    }
}
