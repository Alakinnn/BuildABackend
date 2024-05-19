package com.group07.buildabackend.backend.repository.operations;
/**
 * @author Group_7
 */

public interface Retrievable<T> {
    T retrieveActorById(String id);
}
