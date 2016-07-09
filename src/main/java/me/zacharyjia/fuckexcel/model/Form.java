package me.zacharyjia.fuckexcel.model;

import me.zacharyjia.fuckexcel.model.interfaces.FormField;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by zachary on 16/7/9.
 */
public class Form implements Serializable {

    @Id
    private String id;

    private String title;
    private String tips;
    private FormField[] field;
    private String creator;
    private String[] tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public FormField[] getField() {
        return field;
    }

    public void setField(FormField[] field) {
        this.field = field;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
