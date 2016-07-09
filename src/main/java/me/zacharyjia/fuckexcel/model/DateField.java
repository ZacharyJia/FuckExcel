package me.zacharyjia.fuckexcel.model;

import me.zacharyjia.fuckexcel.model.interfaces.FormField;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by zachary on 16/7/9.
 */
public class DateField extends FormField implements Serializable {

    private Calendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
