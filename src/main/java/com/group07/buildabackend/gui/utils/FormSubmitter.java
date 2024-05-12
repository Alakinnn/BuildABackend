package com.group07.buildabackend.gui.utils;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.gui.SceneManager;
import javafx.concurrent.Task;

import java.util.Objects;
import java.util.concurrent.Callable;

public class FormSubmitter {

    public <T> void onSubmit(TaskSupplier<Response<T>> taskSupplier) {
        try {

            // Start loading
            SceneManager.getInstance().startLoading();

            // Create a background task for sending the request
            Task<Response<T>> task = new Task<>() {
                @Override
                protected Response<T> call() throws Exception {
                    return taskSupplier.get();
                }
            };

            // Set up event handler for task completion
            task.setOnSucceeded(success -> {
                // End loading
                SceneManager.getInstance().endLoading();

                Response<T> res = task.getValue();

                if (res.getData() == null) {
                    AlertManager.showError(res.getResponseMsg());
                    return;
                }

                AlertManager.showInfo(res.getResponseMsg());
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

    public <T> void onSubmit(TaskSupplier<Response<T>> taskSupplier, TaskSupplier<Object> onSuccess) {
        try {

            // Start loading
            SceneManager.getInstance().startLoading();

            // Create a background task for sending the request
            Task<Response<T>> task = new Task<>() {
                @Override
                protected Response<T> call() throws Exception {
                    return taskSupplier.get();
                }
            };

            // Set up event handler for task completion
            task.setOnSucceeded(success -> {
                // End loading
                SceneManager.getInstance().endLoading();

                Response<T> res = task.getValue();

                if (res.getData() == null) {
                    AlertManager.showError(res.getResponseMsg());
                    return;
                }

                AlertManager.showInfo(res.getResponseMsg());

                try {
                    onSuccess.get();
                } catch (Exception e) {
                    e.printStackTrace();
                    AlertManager.showError(e.getMessage());
                }
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
