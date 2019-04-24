package com.boot.web;

import com.alibaba.fastjson.JSONObject;
import com.boot.domain.User;
import com.boot.service.TokenService;
import com.boot.service.UserService;
import com.boot.util.RenderJson;
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

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public RenderJson login(@RequestBody User user) {
        User item = userService.getUserByUsername(user.getUserName());
        if (item == null) {
            return RenderJson.No("1", "Fail", "User does not exist");
        } else {
            if (!item.getUserPassword().equals(user.getUserPassword())) {
                return RenderJson.No("1", "Fail", "Error Password");
            } else {
                String token = tokenService.getToken(item);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token", token);
                return RenderJson.Ok("0", "Success", jsonObject);
            }
        }
    }


}
