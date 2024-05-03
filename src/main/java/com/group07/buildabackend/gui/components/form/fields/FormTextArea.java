package com.group07.buildabackend.gui.components.form.fields;

import javafx.scene.control.TextArea;

public class FormTextArea extends FormField<TextArea, String> {
    public FormTextArea(TextArea control, String label) {
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
