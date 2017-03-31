package com.gcc.course.utils;

/**
 * Created by huangMP on 2017/3/13.
 * decription :
 */
public class RequestResult {

    private int success ;
    private String message ;
    private String url ;

    private Object object;

    public RequestResult() {
        this.success = 0;
        this.message = "图片上传失败!";
        this.url = "";
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
