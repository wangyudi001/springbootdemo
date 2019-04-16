package com.boot.web;

import com.boot.annotation.PassToken;
import com.boot.annotation.UserLoginToken;
import com.boot.util.RenderJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.boot.domain.User;
import com.boot.service.UserService;

import java.util.List;

@Controller
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @UserLoginToken
    public RenderJson getUsers() {
        List<User> userList = userService.getAllUsers();
        return RenderJson.Ok("0", "success", userList);
    }

    @RequestMapping(value = "/getUserByUsername", method = RequestMethod.GET)
    @PassToken
    public RenderJson getUserByUsername(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.getUserByUsername(username);
        return user != null && user.getUserPassword().equals(password) ? RenderJson.Ok("0", "Success", user) : RenderJson.No("1", "fail", "Username or password error! Please check again.");
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @UserLoginToken
    public RenderJson delUserById(@RequestParam("id") Integer id) {
        Boolean bool = userService.delUserById(id);
        return  bool? RenderJson.Ok("0", "Success") : RenderJson.No("1", "Fail", "Unknown Error!");
    }

    @RequestMapping(value = "/upd/{id}", method = RequestMethod.POST)
    @UserLoginToken
    public RenderJson updUserById(@PathVariable String id, @RequestBody User user){
        user.setUserId(id);
        Boolean bool = userService.updUserById(user);
        return bool? RenderJson.Ok("0", "Success") : RenderJson.No("1", "Fail", "Unknown Error!");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @UserLoginToken
    public RenderJson addUser(@RequestBody User user){
        Boolean bool = userService.addUser(user);
        return bool? RenderJson.Ok("0", "Success") : RenderJson.No("1", "Fail", "Unknown Error");
    }
}
