package com.group07.buildabackend.gui.components.form;

import com.group07.buildabackend.gui.components.form.fields.FormField;
import com.group07.buildabackend.gui.exceptions.MissingRequiredFieldException;

import java.util.ArrayList;
import java.util.List;

public class FormController {
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
}
