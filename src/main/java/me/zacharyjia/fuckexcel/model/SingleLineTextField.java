package me.zacharyjia.fuckexcel.model;

import me.zacharyjia.fuckexcel.model.interfaces.FormField;

import java.io.Serializable;

/**
 * Created by zachary on 16/7/9.
 */
public class SingleLineTextField extends FormField implements Serializable {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
