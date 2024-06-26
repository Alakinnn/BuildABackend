package com.group07.buildabackend.gui.components.form.fields;

/**
 * @author Group_7
 */

import javafx.scene.control.TextField;

public class FormTextField extends FormField<TextField, String> {
    public FormTextField(TextField control, String label) {
        super(control, label);
    }

    @Override
    public String getValue() {
        return control.getText();
    }

    @Override
    public boolean isEmpty() {
        return control.getText().isEmpty();
    }
}
