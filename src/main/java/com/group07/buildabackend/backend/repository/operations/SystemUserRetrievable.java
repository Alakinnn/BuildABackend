package com.group07.buildabackend.backend.repository.operations;

public interface SystemUserRetrievable<T> {
    T retrieveActorByEmail(String email);

    T retrieveActorByPhone(String phoneNumber);
}
