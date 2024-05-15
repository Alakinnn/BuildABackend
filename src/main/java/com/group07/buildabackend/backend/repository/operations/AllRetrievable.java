package com.group07.buildabackend.backend.repository.operations;

import java.util.List;

public interface AllRetrievable<T> {
    List<T> retrieveAll();
}
