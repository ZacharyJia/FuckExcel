package me.zacharyjia.fuckexcel.model;

import java.util.Calendar;

/**
 * Created by zachary on 16/7/9.
 */
public class FilledForm extends Form {

    private String formId;
    private String userId;
    private Calendar fillTime;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Calendar getFillTime() {
        return fillTime;
    }

    public void setFillTime(Calendar fillTime) {
        this.fillTime = fillTime;
    }
}
