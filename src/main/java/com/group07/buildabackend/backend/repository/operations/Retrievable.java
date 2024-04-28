package com.group07.buildabackend.backend.repository.operations;

public interface Retrievable<T> {
    T retrieveById(String id);
}
