package com.group07.buildabackend.gui.components.form;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.form.fields.FormField;
import com.group07.buildabackend.gui.exceptions.MissingRequiredFieldException;
import com.group07.buildabackend.gui.utils.AlertManager;
import com.group07.buildabackend.gui.utils.FormSubmitter;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public abstract Response<T> sendRequest();

    public void onSubmit(ActionEvent event) {
        try {
            checkRequiredFields();
            FormSubmitter submitter = new FormSubmitter();
            submitter.onSubmit(this::sendRequest);
        } catch (Exception e) {
            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }
    }
}
