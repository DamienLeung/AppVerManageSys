package com.dfbz.entity;

import java.io.Serializable;

public class ResultMsg implements Serializable {

    public static final int SUCCESS = 1;
    public static final int FALSE = 0;


    private static final long serialVersionUID = -8983127790136097833L;

    private boolean success = false;

    private String msg = "失敗";

    private Object object = null;

    public ResultMsg() {
    }

    public ResultMsg(boolean success, String msg, Object object) {
        this.success = success;
        this.msg = msg;
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }

}
