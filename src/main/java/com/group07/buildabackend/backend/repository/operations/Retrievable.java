package com.group07.buildabackend.backend.repository.operations;

import java.util.List;

public interface Retrievable<T> {
    T retrieveActorById(String id);
}
