package com.group07.buildabackend.gui.components.form;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.gui.components.form.fields.FormField;
import com.group07.buildabackend.gui.exceptions.MissingRequiredFieldException;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class FormController<T> {
    // T is the type that is returned after the form is successfully submitted

    protected List<FormField> requiredFields;

    public FormController() {
        requiredFields = new ArrayList<>();
    }

    protected void addRequiredField(FormField field) {
        // Use this method in the initialize() method for your controller.
        requiredFields.add(field);
    }

    private List<FormField> getMissingFields() {
        List<FormField> missingFields = new ArrayList<>();

        for (FormField field: requiredFields) {
            if (field.isEmpty()) {
                missingFields.add(field);
            }
        }

        return missingFields;
    }



    protected void checkRequiredFields() throws MissingRequiredFieldException {
        // This method will throw a MissingRequiredFieldException when a required field is missing.
        // Make sure to catch this exception before form submission.

        List<FormField> missingFields = getMissingFields();
        if (missingFields.size() > 0) {
            throw new MissingRequiredFieldException(missingFields);
        };
    }

    public abstract Response<T> sendFormRequest();

    // Override this method to execute code before form submission (e.g. check if password valid)
    // True means the form will proceed to submit.
    // False means the form will not submit;
    public boolean preSubmit() {
        return true;
    }

    // Override this to execute code after successful form submission (e.g. redirect pages)
    public void onSuccessfulSubmit() {};

    public void onSubmit(ActionEvent event) {
        if (!preSubmit()) return;

        try {
            checkRequiredFields();

            TaskRunner<Response<T>> runner = new TaskRunner<>(this::sendFormRequest, res -> {
                if (!res.isOk()) {
                    AlertManager.showError(res.getResponseMsg());
                    return;
                };
                AlertManager.showInfo(res.getResponseMsg());
                onSuccessfulSubmit();
            });

            runner.run();
        } catch (MissingRequiredFieldException e) {
            AlertManager.showError(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }
    }
}
