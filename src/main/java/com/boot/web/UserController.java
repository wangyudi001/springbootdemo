package com.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.domain.User;
import com.boot.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
@RestController
public class UserController {
	@Autowired 
	private UserService userService;

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public User getIndex(){
        User user = userService.selectUserById(1);  
        return user;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> userList = new ArrayList<User>();
        userList = userService.getAllUsers();
        return userList;
    }




}
