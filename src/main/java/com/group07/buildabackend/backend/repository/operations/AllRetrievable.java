package com.group07.buildabackend.backend.repository.operations;
/**
 * @author Group_7
 */

import java.util.List;

public interface AllRetrievable<T> {
    List<T> retrieveAll();
}
