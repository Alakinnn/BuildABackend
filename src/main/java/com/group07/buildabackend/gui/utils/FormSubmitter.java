package com.group07.buildabackend.gui.utils;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.form.FormController;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;

public class FormSubmitter {

    public <T> void onSubmit(TaskSupplier<Response<T>> taskSupplier) {
        try {

            // Set cursor to waiting
            SceneManager.getInstance().setCursorLoading();

            // Create a background task for sending the request
            Task<Response<T>> task = new Task<>() {
                @Override
                protected Response<T> call() throws Exception {
                    return taskSupplier.get();
                }
            };

            // Set up event handler for task completion
            task.setOnSucceeded(success -> {
                // Reset cursor to default
                SceneManager.getInstance().setCursorDefault();

                Response<T> res = task.getValue();

                if (res.getData() == null) {
                    AlertManager.showError(res.getResponseMsg());
                    return;
                }

                AlertManager.showInfo(res.getResponseMsg());
            });

            task.setOnFailed(fail -> {
                // Reset cursor to default
                SceneManager.getInstance().setCursorDefault();

                Throwable exception = task.getException();
                exception.printStackTrace();
                AlertManager.showError(exception.getMessage());
            });

            // Start the task
            new Thread(task).start();

        } catch (Exception e) {
            // Reset cursor to default
            SceneManager.getInstance().setCursorDefault();

            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }
    }

    @FunctionalInterface
    public interface TaskSupplier<T> {
        T get() throws Exception;
    }
}
