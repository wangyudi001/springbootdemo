package com.boot.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author wangyudi
 * @Date 2019/4/18 11:25
 * @Version 1.0
 */
@ControllerAdvice
public class GloablExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e){
        String msg = e.getMessage();
        JSONObject jsonObject = new JSONObject();
        if (msg == null || msg.equals("")){
            msg = "Serve Error";
        }

        if (msg.contains("401")){
            String code = "401";
            jsonObject.put("code", code);
            msg = msg.replace("401. ", "");
        }
        jsonObject.put("attr", msg);
        return jsonObject;

    }

}
