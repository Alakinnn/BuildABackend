package com.group07.buildabackend.gui.tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestTaskRunner<T> {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public T run(Callable<T> task) {
        Future<T> future = executor.submit(task::call);

        T result;
        try {
            result = future.get();
        } catch (Exception e) {
            throw new RuntimeException("Task execution failed", e);
        }
        return result;
    }


}
