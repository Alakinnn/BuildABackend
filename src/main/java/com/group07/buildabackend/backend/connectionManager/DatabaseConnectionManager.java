package com.group07.buildabackend.backend.connectionManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public interface DatabaseConnectionManager {
     EntityManagerFactory EMF = Persistence.createEntityManagerFactory("com.group07");
}
