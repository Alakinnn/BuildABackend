package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.connectionManager.DatabaseFactoryManager;
import com.group07.buildabackend.backend.repository.operations.Addable;
import com.group07.buildabackend.backend.repository.operations.Deletable;
import com.group07.buildabackend.backend.repository.operations.Retrievable;
import com.group07.buildabackend.backend.repository.operations.Updatable;
import jakarta.persistence.EntityManager;

public abstract class Repository<T> implements Addable<T>, Deletable<T>, Retrievable<T>, Updatable<T> {
    static EntityManager EM = DatabaseFactoryManager.getEmf().createEntityManager();
    @Override
    public void add(T item) {
        try {
            EM.getTransaction().begin();
            EM.persist(item);
            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
    }

    @Override
    public void update(T item) {
        try {
            EM.getTransaction().begin();
            EM.merge(item);
            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
    }
}
