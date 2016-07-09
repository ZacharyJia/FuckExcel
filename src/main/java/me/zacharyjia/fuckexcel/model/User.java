package me.zacharyjia.fuckexcel.model;

import me.zacharyjia.fuckexcel.model.interfaces.FormField;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by zachary on 16/7/9.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String username;
    private String password;
    private String[] tags;
    private FormField[] fileds;

    public FormField[] getFileds() {
        return fileds;
    }

    public void setFileds(FormField[] fileds) {
        this.fileds = fileds;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{id:" + id + ", username:" + username + ", password:" + password + ", tags:"
                + tags.toString() + "}";
    }

}
