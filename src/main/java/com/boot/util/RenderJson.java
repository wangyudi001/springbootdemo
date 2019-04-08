package com.boot.util;

public class RenderJson {

    private String code = "";
    private String message = "";
    private Object data;
    private Object attr;

    public static RenderJson Ok(String code, String message){
        RenderJson json = new RenderJson();
        json.setCode(code);
        json.setMessage(message);
        return json;
    }

    public static RenderJson Ok(String code, String message, Object data){
        RenderJson json = new RenderJson();
        json.setCode(code);
        json.setMessage(message);
        if(data != null){
            json.setData(data);
        }
        return json;
    }

    public static RenderJson Ok(String code, String message, Object data, Object attr){
        RenderJson json = new RenderJson();
        json.setCode(code);
        json.setMessage(message);
        if(data != null){
            json.setData(data);
        }
        json.setAttr(attr);
        return json;
    }

    public static RenderJson No(String errCode, String errMessage){
        RenderJson json = new RenderJson();
        json.setCode(errCode);
        json.setMessage(errMessage);
        return json;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getAttr() {
        return attr;
    }

    public void setAttr(Object attr) {
        this.attr = attr;
    }
}
