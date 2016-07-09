package me.zacharyjia.fuckexcel.model;

import me.zacharyjia.fuckexcel.model.interfaces.FormField;

import java.io.Serializable;

/**
 * Created by zachary on 16/7/9.
 */
public class SingleOptionField extends FormField implements Serializable {

    private String[] options;
    private String value;

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
