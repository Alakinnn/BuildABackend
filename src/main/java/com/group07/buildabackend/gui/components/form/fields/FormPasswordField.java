package com.group07.buildabackend.gui.components.form.fields;

/**
 * @author Group_7
 */

import javafx.scene.control.PasswordField;

public class FormPasswordField extends FormField<PasswordField, String>{

    public FormPasswordField(PasswordField control, String label) {
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
