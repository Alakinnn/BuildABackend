package com.group07.buildabackend.gui.components.form.fields;

import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.scene.control.ChoiceBox;

public class FormChoiceBox<T> extends FormField<ChoiceBox<ChoiceField<T>>, T> {

    public FormChoiceBox(ChoiceBox<ChoiceField<T>> control, String label) {
        super(control, label);
    }

    @Override
    public T getValue() {
        return control.getValue().getValue();
    }

    @Override
    public boolean isEmpty() {
        return control.getValue() == null;
    }
}
