package com.group07.buildabackend.gui.tasks;

import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.concurrent.Task;

import java.util.function.Consumer;

public class TaskRunner<T> {
    // Class to run asynchronous operations.
    // Will render a loading spinner while running.
    // Will render a loading spinner while running.

    private T result;

    public TaskRunner() {
    }

    public T getResult() {
        return result;
    }

    public void run(TaskSupplier<T> taskSupplier) {
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

                result = task.getValue();
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

    public void run(TaskSupplier<T> taskSupplier, Consumer<T> onSuccess) {
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
                result = task.getValue();
                onSuccess.accept(result);
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
