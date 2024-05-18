package com.group07.buildabackend.gui.utils;

/**
 * @author Group_7
 */

public class ChoiceField<T> {
    // Helper class for ChoiceBox to separate label from value

    private String label;
    private T value;

    public ChoiceField(String label, T value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return label;
    }
}
