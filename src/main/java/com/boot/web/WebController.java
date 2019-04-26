package com.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.domain.User;
import com.boot.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("")
public class WebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String getIndex(Model model) {
        List<User> list = new ArrayList<User>();
        list = userService.getAllUsers();
        model.addAttribute("list", list);
        model.addAttribute("info", "hello!");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String getIndex() {
        return "login";
    }
}
