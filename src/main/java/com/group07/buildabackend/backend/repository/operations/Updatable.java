package com.group07.buildabackend.backend.repository.operations;

import com.group07.buildabackend.backend.model.insuranceClaim.Document;

import java.util.List;

public interface Updatable<T> {
    void update(T item);
}
