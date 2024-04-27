package com.group07.buildabackend.connectionManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public interface DatabaseConnectionManager {
    public static EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.group07");
}
