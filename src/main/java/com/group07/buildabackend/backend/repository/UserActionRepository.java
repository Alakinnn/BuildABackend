package com.group07.buildabackend.backend.repository;

import com.group07.buildabackend.backend.model.userAction.UserAction;
import jakarta.persistence.Query;

public class UserActionRepository extends Repository<UserAction> {
    @Override
    public UserAction retrieveActorById(String id) {
        Query query = entityManager.createQuery("FROM UserAction ua WHERE ua.actionId = :id");
        query.setParameter("id", id);

        return (UserAction) query.getSingleResult();
    }
}
