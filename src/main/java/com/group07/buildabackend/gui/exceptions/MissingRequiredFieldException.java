package com.group07.buildabackend.gui.exceptions;

import com.group07.buildabackend.gui.components.form.fields.FormField;

import java.util.List;

public class MissingRequiredFieldException extends Exception{
    public MissingRequiredFieldException(List<FormField> missingFields) {
        super(getErrorMsg(missingFields));
    }

    private static String getErrorMsg(List<FormField> fields) {
        StringBuilder s = new StringBuilder("Missing required field(s): ");
        for (FormField field: fields) {
            s.append(field.getLabel());
            s.append(", ");
        }
        return s.toString();
    }
}
