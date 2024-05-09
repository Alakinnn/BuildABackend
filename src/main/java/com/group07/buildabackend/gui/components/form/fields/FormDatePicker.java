package com.group07.buildabackend.gui.components.form.fields;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class FormDatePicker extends FormField<DatePicker, LocalDate> {
    public FormDatePicker(DatePicker control, String label) {
        super(control, label);
    }

    @Override
    public LocalDate getValue() {
        return control.getValue();
    }

    @Override
    public boolean isEmpty() {
        return control.getValue() == null;
    }
}
