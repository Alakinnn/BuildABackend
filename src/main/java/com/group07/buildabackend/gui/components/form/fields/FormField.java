package com.group07.buildabackend.gui.components.form.fields;

/**
 * @author Group_7
 */

public abstract class FormField<T, K> {
    // T is the javafx control used for the field
    // K is the return type of this field

    protected T control;
    protected String label;

    public FormField() {
    }

    public FormField(T control, String label) {
        this.control = control;
        this.label = label;
    }

    public abstract K getValue();

    public abstract boolean isEmpty();

    public String getLabel() {
        return label;
    }
}
