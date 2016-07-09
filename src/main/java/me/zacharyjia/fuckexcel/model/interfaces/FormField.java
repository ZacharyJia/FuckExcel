package me.zacharyjia.fuckexcel.model.interfaces;

import org.springframework.data.annotation.Id;

/**
 * Created by zachary on 16/7/9.
 */
public abstract class FormField {
    @Id
    private String id;
    private String title; //field name
    private int sort; //order in the form
    private boolean isMust; //whether this field is required or optional
    private String tips; //tips will display below the title in smaller font

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean isMust() {
        return isMust;
    }

    public void setMust(boolean must) {
        isMust = must;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
