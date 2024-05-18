package com.group07.buildabackend.backend.repository.operations;
/**
 * @author Group_7
 */
public interface SystemUserRetrievable<T> {
    T retrieveActorByEmail(String email);

    T retrieveActorByPhone(String phoneNumber);
}
