package com.boot.web;

import com.alibaba.fastjson.JSONObject;
import com.boot.domain.User;
import com.boot.service.TokenService;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangyudi
 * @Date 2019/4/16 13:44
 * @Version 1.0
 */

@Controller
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "log", method = RequestMethod.POST)
    public JSONObject login(@RequestBody User user) {
        User item = userService.getUserByUsername(user.getUserName());
        JSONObject jsonObject = new JSONObject();
        if (item == null) {
            jsonObject.put("message", "Fail");
            jsonObject.put("code", "1");
            jsonObject.put("attr", "User does not exist");
            return jsonObject;
        } else {
            if(!item.getUserPassword().equals(user.getUserPassword())){
                jsonObject.put("message", "Fail");
                jsonObject.put("code", "1");
                jsonObject.put("attr", "Error Password");
                return jsonObject;
            }else {
                String token = tokenService.getToken(item);
                jsonObject.put("message", "Success");
                jsonObject.put("code", "0");
                jsonObject.put("token", token);
                return jsonObject;
            }
        }
    }



}
