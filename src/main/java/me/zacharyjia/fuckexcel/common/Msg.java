package me.zacharyjia.fuckexcel.common;

/**
 * Created by zachary on 16/7/10.
 */
public class Msg {

    private String msg;
    private String type;

    public Msg(String type, String msg) {
        this.msg = msg;
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
