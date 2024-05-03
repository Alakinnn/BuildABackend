package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.connectionManager.DatabaseFactoryManager;
import com.group07.buildabackend.backend.repository.operations.Addable;
import com.group07.buildabackend.backend.repository.operations.Deletable;
import com.group07.buildabackend.backend.repository.operations.Retrievable;
import com.group07.buildabackend.backend.repository.operations.Updatable;
import jakarta.persistence.EntityManager;

public abstract class Repository<T> implements Addable<T>, Deletable<T>, Retrievable<T>, Updatable<T> {
    protected static final EntityManager entityManager = DatabaseFactoryManager.getEmf().createEntityManager();

    @Override
    public void add(T item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void update(T item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }
}
