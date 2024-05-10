package com.group07.buildabackend.gui.tasks;

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.concurrent.Task;

public class TaskRunner {
    // Class to run asynchronous operations.
    // Will render a loading spinner while running.
    // Will render a loading spinner while running.

    public <T> void run(TaskSupplier<T> taskSupplier) {
        try {

            // Start loading
            SceneManager.getInstance().startLoading();

            // Create a background task for sending the request
            Task<T> task = new Task<>() {
                @Override
                protected T call() throws Exception {
                    return taskSupplier.get();
                }
            };

            // Set up event handler for task completion
            task.setOnSucceeded(success -> {
                // End loading
                SceneManager.getInstance().endLoading();

                T res = task.getValue();
            });

            task.setOnFailed(fail -> {
                // End loading
                SceneManager.getInstance().endLoading();

                Throwable exception = task.getException();
                exception.printStackTrace();
                AlertManager.showError(exception.getMessage());
            });

            // Start the task
            new Thread(task).start();

        } catch (Exception e) {
            // End loading
            SceneManager.getInstance().endLoading();

            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }
    }

    @FunctionalInterface
    public interface TaskSupplier<T> {
        T get() throws Exception;
    }
}
