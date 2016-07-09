package me.zacharyjia.fuckexcel.model;

import me.zacharyjia.fuckexcel.model.interfaces.FormField;

import java.io.Serializable;

/**
 * Created by zachary on 16/7/9.
 */
public class MultiOptionField extends FormField implements Serializable {

    private String[] options;
    private String[] values;

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
